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
    private String GroupPhotoPath;
    private String PrimaryAdmin;
    private ArrayList<String> OtherAdmins=new ArrayList<>();
    private ArrayList<String> Users=new ArrayList<>();
    private ArrayList<String> Posts=new ArrayList<>();
    private ArrayList<String> newPostreq=new ArrayList<>();
    private ArrayList<String> newAdminsreq=new ArrayList<>();
    
    

    public Group(String name, String Discription, String PrimaryAdmin) {
        this.ID="Group"+String.format("%03d", count++);
        this.name = name;
        if(PrimaryAdmin!=null)
        {
            this.Discription = Discription;
        }
        this.PrimaryAdmin = PrimaryAdmin;
        this.OtherAdmins=new ArrayList<>();
        this.Users=new ArrayList<>();
        this.Posts=new ArrayList<>();
        this.newAdminsreq=new ArrayList<>();
        this.newPostreq=new ArrayList<>();
    }
    
    

    public void UpdatePhoto(String GroupPhotoPath) {
        this.GroupPhotoPath = GroupPhotoPath;
        LOGIN.groupdatabase.saveToFile();
    }

    public void setPosts(ArrayList<String> Posts) {
        this.Posts = Posts;
    }

    public ArrayList<String> getNewPostsreq() {
        return newPostreq;
    }

    public void setNewPostsreq(ArrayList<String> newPostsreq) {
        this.newPostreq = newPostsreq;
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
    
    // Check if there are any users in the group
    if (Users != null) {
        // Iterate through each username in the 'Users' list
        for (String userS : Users) {
            // Iterate over all users in the database and match the username
            for (UserAccount userO : LOGIN.database.getUsers()) {
                if (userO.getUsername().equals(userS)) {
                    userList.add(userO); // Add matching user to the list
                }
            }
        }
    }
        return userList; // Return the list of UserAccount objects
   }
    public ArrayList<UserAccount> getObjectNewAdminsREQ() {
    ArrayList<UserAccount> newadminList = new ArrayList<>();
    
    // Check if there are any users in the group
    if (newAdminsreq != null) {
        // Iterate through each username in the 'Users' list
        for (String userS : newAdminsreq) {
            // Iterate over all users in the database and match the username
            for (UserAccount userO : LOGIN.database.getUsers()) {
                if (userO.getUsername().equals(userS)) {
                    newadminList.add(userO); // Add matching user to the list
                }
            }
        }
    }
        return newadminList; // Return the list of UserAccount objects
   }


    
    
    public ArrayList<UserAccount> getObjectAdmins() 
    {
        ArrayList<UserAccount> userList = new ArrayList<>();
    
    // Check if there are any users in the group
    if (OtherAdmins != null) {
        // Iterate through each username in the 'Users' list
        for (String userS : OtherAdmins) {
            // Iterate over all users in the database and match the username
            for (UserAccount userO : LOGIN.database.getUsers()) {
                if (userO.getUsername().equals(userS)) {
                    userList.add(userO); // Add matching user to the list
                }
            }
        }
    }
        return userList; // Return the list of UserAccount objects
    }
    
    
    public ArrayList<Post> getObjectPost() {
        ArrayList<Post> postList = new ArrayList<>();
        if (Posts != null) {
            for (String postS : Posts) {
                for (Content post : Newsfeed.contents.getContentList()) {
                    
                    if (post.getContentId().equals(postS) && post instanceof Post && post.getType().equals("Post"))
                    {
                        System.out.println("Here");
                        postList.add((Post) post);
                    }
                    
                }

            }
            return postList;
        }
        return null;
    }
    public ArrayList<Post> getObjectNewPostREQ() {
        ArrayList<Post> newpostList = new ArrayList<>();
        if (newPostreq != null) {
            for (String postS : newPostreq) {
                for (Content post : Newsfeed.contents.getContentList()) {
                    
                    if (post.getContentId().equals(postS));
                    {
                        newpostList.add((Post) post);
                    }

                }

            }
            return newpostList;
        }
        return null;
    }
    
    public Post getPost()
    {
        for (Post p: this.getObjectPost())
        {
            if(p.getContentId().equals(Newsfeed.PostC))
            {
                return p;
            }
            
        }
        return null;
    }
    
    
    
}
