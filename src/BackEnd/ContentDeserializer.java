/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/**
 *
 * @author lenovo
 */
public class ContentDeserializer implements JsonDeserializer <Content> {
    @Override
    public Content deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString(); 
        
        switch (type) {
            case "Post":
                return context.deserialize(jsonObject, Post.class);
            case "Storie":
                return context.deserialize(jsonObject, Storie.class);
            default:
                throw new JsonParseException("Unknown content type: " + type);
        }
    }
}
