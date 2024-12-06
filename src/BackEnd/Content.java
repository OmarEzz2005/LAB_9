/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author yaseen
 */
public abstract class Content 
{
    public static int countC=0;
    private final  String ContentId;
    private final String autherId;
    private String ContenText;
    private String ImgPath;
    private final long timestamp;
    private String type;

    public Content( UserAccount User, String ContenText, String ImgPath,String type ) 
    {
        this.ContentId = "contant"+String.format("%03d", countC++);
        this.autherId = User.getSearchKey();
        this.ContenText = ContenText;
        this.ImgPath=ImgPath;
        this.timestamp = System.currentTimeMillis();
        this.type=type;
    }

    public String getContentId() {
        return ContentId;
    }
    public String getSearchKey()
    {
        return autherId;
    }
    public String getContenText() {
        return ContenText;
    }
    

    public void setContenText(String ContenText) {
        this.ContenText = ContenText;
    }

    
    public String getImgPath() {
        
        return ImgPath;
    }
    public void setImgPath(String ImgPath) {
        if(ImgPath==null||ImgPath.isEmpty())
        {
            this.ImgPath="Noimage";
        }
        else
        {
        this.ImgPath = ImgPath;
        }
    }
    public long getTimestamp() {
        return timestamp;
    }
      public void deleteContent(String fileName) 
      {
    RuntimeTypeAdapterFactory<Content> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory.of(Content.class, "type").registerSubtype(Storie.class, "Storie"); 
    Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();

    try (FileReader reader = new FileReader(fileName)) {
        
        List<Content> contentList = gson.fromJson(reader, new TypeToken<List<Content>>() {}.getType());
        contentList.removeIf(content -> content instanceof Storie && (((Storie) content).getContentId() == null ? this.getContentId() == null : ((Storie) content).getContentId().equals(this.getContentId())));
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(contentList, writer);
            System.out.println("Content with ID " + this.getContentId() + " was successfully removed.");
        }

    } catch (IOException e) {
        System.err.println("Error reading or writing the file: " + e.getMessage());
    }
}
    public abstract String getType();
}
