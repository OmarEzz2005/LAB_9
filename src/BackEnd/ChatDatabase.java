/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class ChatDatabase implements Database{
    private String filename;
    private ArrayList<Message> chatList = new ArrayList<>();

    public ChatDatabase(String file) {
        this.filename = file;

    }

    public ArrayList<Message> getChats() {
        return chatList;
    }

    @Override
    public void saveToFile() {
        Path filepath = Paths.get(filename);
        try (FileWriter writer = new FileWriter(filepath.toFile())) {
            Gson gson = new Gson();
            String jsonContent = gson.toJson(chatList);
            writer.write(jsonContent);
        } catch (IOException e) {
            System.out.println("Error while writing to the file!");
        }
    }

    @Override
    public void readFromFile() {
        Path filepath = Paths.get(filename);
        try {
            if (Files.exists(filepath)) {
                String jsonContent = new String(Files.readAllBytes(filepath));
                Gson gson = new Gson();
                chatList = gson.fromJson(jsonContent, new TypeToken<List<Message>>() {
                }.getType());
                if (chatList == null) {
                    chatList = new ArrayList<>();
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error while reading the file!");
        }
    }

    @Override
    public boolean contains(String key) {
        for (Message c : chatList) {
            if (c.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Message getRecord(String key) {
        for (Message c : chatList) {
            if (c.getSearchKey().equals(key)) {
                return c;
            }
        }
        return null;
    }

    public void insertRecord(Message record) {
        if (contains(record.getSearchKey())) {
            JOptionPane.showMessageDialog(null, "Error, There is a chat with the same ID !!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        chatList.add(record);
        saveToFile();
        JOptionPane.showMessageDialog(null, "Chat with ID " + record.getSearchKey() + " was successfully added", "Message", JOptionPane.INFORMATION_MESSAGE);

    }

    @Override
    public void deleteRecord(String key) {
        if (!contains(key)) {
            JOptionPane.showMessageDialog(null, "Group not found !!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Message c : chatList) {
            if (c.getSearchKey().equals(key)) {
                chatList.remove(c);
                JOptionPane.showMessageDialog(null, "Chat with ID " + key + " was successfully removed", "Message", JOptionPane.INFORMATION_MESSAGE);
                saveToFile();
                return;
            }
        }
    }
}
