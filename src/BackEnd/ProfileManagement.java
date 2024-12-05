package BackEnd;
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
    public void updatePassword(String newPassword){
        password = newPassword;
        hashedPassword = UserAccount.hashPassword(newPassword);
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
    public String getHashedPassword(){
        return hashedPassword;
    }
    public String getPassword(){
        return password;
    }
    
}
