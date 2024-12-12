/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import FrontEnd.LOGIN;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
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
 * @author yaseen
 */
public class GroupDatabase {

    private String filename;
    private ArrayList<Group> groupList = new ArrayList<>();

    public GroupDatabase(String file) {
        this.filename = file;

    }

    public ArrayList<Group> getgroups() {
        return groupList;
    }

    public void saveToFile() {
        Path filepath = Paths.get(filename);
        try (FileWriter writer = new FileWriter(filepath.toFile())) {
            Gson gson = new Gson();
            String jsonContent = gson.toJson(groupList);
            writer.write(jsonContent);
        } catch (IOException e) {
            System.out.println("Error while writing to the file!");
        }
    }

    public void readFromFile() {
        Path filepath = Paths.get(filename);
        try {
            if (Files.exists(filepath)) {
                String jsonContent = new String(Files.readAllBytes(filepath));
                Gson gson = new Gson();
                groupList = gson.fromJson(jsonContent, new TypeToken<List<Group>>() {
                }.getType());
                if (groupList == null) {
                    groupList = new ArrayList<>();
                }
            }
            Group.count = groupList.size();
        } catch (IOException e) {
            System.out.println("Error while reading the file!");
        }
    }

    public boolean contains(String key) {
        for (Group c : groupList) {
            if (c.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Group getRecord(String key) {
        for (Group c : groupList) {
            if (c.getSearchKey().equals(key)) {
                return c;
            }
        }
        return null;
    }

    public void insertRecord(Group record) {
        if (contains(record.getSearchKey())) {
            JOptionPane.showMessageDialog(null, "Error, There is a Group with the same Name !!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        groupList.add(record);
        saveToFile();
        JOptionPane.showMessageDialog(null, "Group with Name " + record.getSearchKey() + " was successfully added", "Message", JOptionPane.INFORMATION_MESSAGE);

    }

    public void deleteRecord(String key) {
        if (!contains(key)) {
            JOptionPane.showMessageDialog(null, "Group not found !!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Group c : groupList) {
            if (c.getSearchKey().equals(key)) {
                groupList.remove(c);
                JOptionPane.showMessageDialog(null, "Group with ID " + key + " was successfully removed", "Message", JOptionPane.INFORMATION_MESSAGE);
                saveToFile();
                return;
            }
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
