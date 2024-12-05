/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import FrontEnd.LOGIN;

/**
 *
 * @author lenovo
 */

public class ProfileManagement {

    
    protected String profilePhotoPath;
    protected String coverPhotoPath;
    protected String bio;
    
    public void updateProfilePhoto(String profilePhotopath){
        this.profilePhotoPath = profilePhotopath;
        LOGIN.database.saveToFile();
    }
    public void updateCoverPhoto(String coverPhotoPath){
        this.coverPhotoPath = coverPhotoPath;
        LOGIN.database.saveToFile();
    }
    public void updateBio(String bio){
        this.bio = bio;
        LOGIN.database.saveToFile();
    }
    
    public String getProfilePhotoPath(){
        return profilePhotoPath;
    }
    public String getCoverPhotoPath(){
        return coverPhotoPath;
    }
    public String getBio(){
        return bio;
    }
    
    
}


