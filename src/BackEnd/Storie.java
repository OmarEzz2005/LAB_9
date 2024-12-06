/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author yaseen
 */
public class Storie extends Content{
    
    private final long time=24*60*60*1000;

    public Storie(UserAccount User, String ContenText, String ImgPath, String type) {
        super(User, ContenText, ImgPath, "Storie");
    }
    public void isExpired()
    {
        if(this.getTimestamp()==time)
        {
            this.deleteContent("Content.json");
        }
    }

    @Override
    public String getType() {
       return "Storie";
    }
    
    }

   