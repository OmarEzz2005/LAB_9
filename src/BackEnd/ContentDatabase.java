
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;

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

    public ArrayList<Content> getContentList() {
        return contentList;
    }
    
    public void saveToFile() {
    Gson gson = new Gson();
    File file = new File(this.FileName);
    if (!file.exists()) {
        try {
            
            try (FileWriter writer = new FileWriter(file)) {
                gson.toJson(contentList, writer);
                System.out.println("File created and data successfully saved to file: " + this.FileName);
            }
        } catch (IOException e) {
            System.err.println("Error creating and saving to file: " + e.getMessage());
        }
    } else {
        try {
            try (FileWriter writer = new FileWriter(file)) {
                gson.toJson(contentList, writer);
                System.out.println("Data successfully saved to existing file: " + this.FileName);
            }
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }
}

    public void readFromFile() {
    Gson gson = new GsonBuilder()
        .registerTypeAdapter(Content.class, new ContentDeserializer())
        .create();
    try (FileReader reader = new FileReader(FileName)) {
        ArrayList<Content> loadedContent = gson.fromJson(reader, new TypeToken<List<Content>>() {}.getType());
        if (loadedContent != null) {
            contentList.clear();
            contentList.addAll(loadedContent);
        }
    } catch (IOException e) {
        System.out.println("Cannot read the file: " + e.getMessage());
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
    
     public void deleteRecord(String key) {
        if (!contains(key)) {
            JOptionPane.showMessageDialog(null, "content not found !!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
          Iterator<Content> iterator = contentList.iterator();
    
          while (iterator.hasNext()) {
        
              Content c = iterator.next();
        
              if (c.getSearchKey().equals(key)) {
            
                  iterator.remove();
           
                  JOptionPane.showMessageDialog(null, "Post with ID " + key + " was successfully removed", "Message", JOptionPane.INFORMATION_MESSAGE);
            
                  saveToFile();
            
                  return;
        }
    }}
     
     public int getSize()
     {
         return this.contentList.size();
     }
     
     
     
}
