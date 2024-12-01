/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class UserDatabase {
    private String filename;
    private ArrayList<UserAccount> users = new ArrayList<>();

    public UserDatabase(String file) {
        this.filename = file;
        
    }

    public ArrayList<UserAccount> getUsers() {
        return users;
    }
    
    
    public void readFromFile() {
        Path filepath = Paths.get(filename);
        try {
            if (Files.exists(filepath)) {
                String jsonContent = new String(Files.readAllBytes(filepath));
                Gson gson = new Gson();
                users = gson.fromJson(jsonContent, new TypeToken<List<UserAccount>>(){}.getType());
                if (users == null) {
                    users = new ArrayList<>(); 
                }
            }
            UserAccount.count = users.size();
        } catch (IOException e) {
            System.out.println("Error while reading the file!");
        }
    }
    
    
    public boolean contains(String key) {
        for (UserAccount c : users) {
            if (c.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }
    
    
    
     public UserAccount getRecord(String key) {
        for (UserAccount c : users) {
            if (c.getSearchKey().equals(key)) {
                return c;
            }
        }
        return null;
    }
    
    
     
     public void insertRecord(UserAccount record) {
        if (contains(record.getSearchKey())) {
            JOptionPane.showMessageDialog(null, "Error, There is a User with the same ID !!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        users.add(record);
        saveToFile();
        JOptionPane.showMessageDialog(null, "User with ID " + record.getSearchKey() + " was successfully added", "Message", JOptionPane.INFORMATION_MESSAGE);
 
    }
     
     
     public void deleteRecord(String key) {
        if (!contains(key)) {
            JOptionPane.showMessageDialog(null, "User not found !!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (UserAccount c : users) {
            if (c.getSearchKey().equals(key)) {
                users.remove(c);
                JOptionPane.showMessageDialog(null, "User with ID " + key + " was successfully removed", "Message", JOptionPane.INFORMATION_MESSAGE);
                saveToFile();
                return;
            }
        }
    }
     
     
     public void saveToFile() {
        Path filepath = Paths.get(filename);
        try (FileWriter writer = new FileWriter(filepath.toFile())) {
            Gson gson = new Gson();
            String jsonContent = gson.toJson(users);
            writer.write(jsonContent);
        } catch (IOException e) {
            System.out.println("Error while writing to the file!");
        }
    }
     
     
    
    
    
}
