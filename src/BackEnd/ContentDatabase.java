
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
        ensureimagesFolderExists();
    }

    public ArrayList<Content> getContent() {
        return contentList;
    }

    public void ensureimagesFolderExists()
    {
        String imagesFolder = "img";
    File dir = new File(imagesFolder);
    if (!dir.exists()) {
        dir.mkdir(); 
        System.out.println("Created directory: " + imagesFolder);
    } else {
        System.out.println("Directory already exists: " + imagesFolder);
    }
    }
    public void saveToFile() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(this.FileName)) {
            gson.toJson(contentList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    try (FileWriter writer = new FileWriter(this.FileName)) {
        gson.toJson(contentList, writer);
        System.out.println("Data successfully saved to file: " + this.FileName);
    } catch (IOException e) {
        System.err.println("error saving to file "+e.getMessage());
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
            System.out.println("can not read the file ! "+e.getMessage());
        }
        for (Content content : contentList) {
    
            if (content.getImgPath() != null && !content.getImgPath().isEmpty()) 
            {
                File imgFile = new File(content.getImgPath());
                if (!imgFile.exists()) 
                {
                    content.setImgPath("img/" + new File(content.getImgPath()).getName());
                }
            }
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
        if(record.getImgPath()!=null&&!record.getImgPath().isEmpty())
        {
         String sourcePath=record.getImgPath();
        saveImageToAppDirectory(sourcePath,"img/");
        record.setImgPath("img/"+new File(sourcePath).getName());
        }
        

        contentList.add(record);
        saveToFile();
        JOptionPane.showMessageDialog(null, "content with ID " + record.getSearchKey() + " was successfully added", "Message", JOptionPane.INFORMATION_MESSAGE);
 
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
    public void saveImageToAppDirectory(String sourcePath, String targetDirectory) {
    try {
        
        File sourceFile = new File(sourcePath);
        if(!sourceFile.exists())
        {
            JOptionPane.showMessageDialog(null, "the source image doesnt exise !","error" ,JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        File targetDir = new File(targetDirectory);
        if (!targetDir.exists()) {
            targetDir.mkdirs(); 
        }
        
         File targetFile = new File(targetDir, sourceFile.getName());
        if (targetFile.exists()) {
            JOptionPane.showMessageDialog(null, "The file already exists and will be overwritten.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
        
        Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        JOptionPane.showMessageDialog(null, "Image successfully saved to " + targetFile.getPath(), "Success", JOptionPane.INFORMATION_MESSAGE);
        
        
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error saving image: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
}
