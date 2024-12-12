/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import FrontEnd.*;
import java.util.ArrayList;

/**
 *
 * @author yaseen
 */
public class Group 
{
    private String ID;
    public static int count =0;
    private String name;
    private String Discription	;
    private String GroupPhotoPath="/Users/yaseen/Downloads/WhatsApp Image 2023-07-13 at 4.43.29 PM.jpeg";
    private String PrimaryAdmin;
    private ArrayList<String> OtherAdmins=new ArrayList<>();
    private ArrayList<String> Users=new ArrayList<>();
    private ArrayList<String> Posts=new ArrayList<>();
    private ArrayList<String> newAdminsreq=new ArrayList<>();
    private ArrayList<String> newUserreq=new ArrayList<>();
    
    

    public Group(String name, String Discription, String PrimaryAdmin) {
        this.ID="Group"+String.format("%.3d", count++);
        this.name = name;
        if(PrimaryAdmin!=null)
        {
            this.Discription = Discription;
        }
        this.PrimaryAdmin = PrimaryAdmin;
        this.GroupPhotoPath = "R.png";
        this.OtherAdmins=new ArrayList<>();
        this.Users=new ArrayList<>();
        this.Posts=new ArrayList<>();
        this.newAdminsreq=new ArrayList<>();
        this.newUserreq=new ArrayList<>();
    }

    public ArrayList<String> getNewUserreq() {
        return newUserreq;
    }

    public void setNewUserreq(ArrayList<String> newUserreq) {
        this.newUserreq = newUserreq;
    }
    

    public void UpdatePhoto(String GroupPhotoPath) {
        this.GroupPhotoPath = GroupPhotoPath;
        LOGIN.groupdatabase.saveToFile();
    }

    public void setPosts(ArrayList<String> Posts) {
        this.Posts = Posts;
    }

    public ArrayList<String> getNewAdminsreq() {
        return newAdminsreq;
    }

    public void setNewAdminsreq(ArrayList<String> newAdminsreq) {
        this.newAdminsreq = newAdminsreq;
    }
    
    
    public void setOtherAdmins(ArrayList<String> OtherAdmins) {
        this.OtherAdmins = OtherAdmins;
    }

    public void setUsers(ArrayList<String> Users) {
        this.Users = Users;
    }
    

    public String getSearchKey() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPosts() {
        return Posts;
    }
    

    public String getDiscription() {
        return Discription;
    }

    public String getGroupPhotoPath() {
        return GroupPhotoPath;
    }

    public String getPrimaryAdmin() {
        return PrimaryAdmin;
    }

    public ArrayList<String> getOtherAdmins() {
        return OtherAdmins;
    }

    public ArrayList<String> getUsers() {
        return Users;
    }
    public ArrayList<UserAccount> getObjectUser() {
        ArrayList<UserAccount> userList = new ArrayList<>();
        if (newUserreq != null) {
            for (String userS : newUserreq) {
                for (UserAccount userO : LOGIN.database.getUsers()) {
                    if (userO.getUsername().equals(userS)) {
                        userList.add(userO);
                    }

                }

            }
            return userList;
        }
        return null;
    }

    
    
    public ArrayList<UserAccount> getObjectAdmins() 
    {
        ArrayList<UserAccount> userList = new ArrayList<>();
        if (newAdminsreq != null) {
            for (String userS : newAdminsreq) {
                for (UserAccount userO : LOGIN.database.getUsers()) {
                    if (userO.getUsername().equals(userS)) {
                        userList.add(userO);
                    }

                }

            }
            return userList;
        }
        return null;
    }
    
    
    public ArrayList<Post> getObjectPost() {
        ArrayList<Post> postList = new ArrayList<>();
        if (Posts != null) {
            for (String postS : Posts) {
                for (Content post : Newsfeed.contents.getContentList()) {
                    
                    if (post.getContentId().equals(postS));
                    {
                        postList.add((Post) post);
                    }

                }

            }
            return postList;
        }
        return null;
    }
    
}
