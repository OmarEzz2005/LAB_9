/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author yaseen
 */
public class Post extends Content{ 

    
    
    public Post(UserAccount User, String ContenText, String ImgPath, String type) {
        super(User, ContenText, ImgPath, "Post");
    }
    @Override
    public String getType() {
        return "Post";
    }
    

    
    
    
    
    
}
