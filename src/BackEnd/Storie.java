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
    
    private final long time=24;

    public Storie( UserAccount User, String ContenText) {
        super( User, ContenText);
    }
    
    public boolean isExpired()
    {
        if(this.getTimestamp()==time)
        {
            return true;
        }
        return false;
        
    }
    
    
    }

   