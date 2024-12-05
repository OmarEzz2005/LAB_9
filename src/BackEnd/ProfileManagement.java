/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author lenovo
 */

public class ProfileManagement {

    protected String profilePhotoPath;
    protected String coverPhotoPath;
    protected String bio;
    protected String password;
    protected String hashedPassword;
    
    public void updateProfilePhoto(String profilePhotopath){
        this.profilePhotoPath = profilePhotopath;
    }
    public void updateCoverPhoto(String coverPhotoPath){
        this.coverPhotoPath = coverPhotoPath;
    }
    public void updateBio(String bio){
        this.bio = bio;
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


