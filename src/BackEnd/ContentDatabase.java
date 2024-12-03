/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author yaseen
 */
public class ContentDatabase {

    private final String FileName;
    private final ArrayList<Content> contentList = new ArrayList<>();

    public ContentDatabase(String file) {
        this.FileName = file;
    }

    public ArrayList<Content> getContent() {
        return contentList;
    }

    public void saveToFile() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(this.FileName)) {
            gson.toJson(contentList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FileName)) {
            ArrayList<Content> loadedContent = gson.fromJson(reader, new TypeToken<List<Content>>() {}.getType());
            if (loadedContent != null) {
                contentList.clear();
                contentList.addAll(loadedContent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean contains(String key) {
        for (Content c : contentList) {
            if (c.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }
    
    
    
     public Content getRecord(String key) {
        for (Content c : contentList) {
            if (c.getSearchKey().equals(key)) {
                return c;
            }
        }
        return null;
    }
    
    
     
     public void insertRecord(Content record) {
        if (contains(record.getSearchKey())) {
            JOptionPane.showMessageDialog(null, "Error, There is a Post with the same ID !!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        contentList.add(record);
        saveToFile();
        JOptionPane.showMessageDialog(null, "content with ID " + record.getSearchKey() + " was successfully added", "Message", JOptionPane.INFORMATION_MESSAGE);
 
    }
     
     
     public void deleteRecord(String key) {
        if (!contains(key)) {
            JOptionPane.showMessageDialog(null, "User not found !!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Content c : contentList) {
            if (c.getSearchKey().equals(key)) {
                contentList.remove(c);
                JOptionPane.showMessageDialog(null, "post with ID " + key + " was successfully removed", "Message", JOptionPane.INFORMATION_MESSAGE);
                saveToFile();
                return;
            }
        }
    }
}
