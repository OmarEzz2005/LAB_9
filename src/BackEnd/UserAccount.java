/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import FrontEnd.LOGIN;
import java.time.LocalDate;
import java.security.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class UserAccount {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static int count = 0;
    private String userID;
    private String email;
    private String username;
    private String Gender;
    private String password;
    private String date;
    private String status;
    private ArrayList <String> friends; 
    private ArrayList <String> blocked; 
    private ArrayList <String> requests;
    private ArrayList <Group> joinedGroups;
    private ProfileManagement profile = new ProfileManagement();

    public UserAccount(String email, String username, String Gender, String password, LocalDate date) {
        this.userID = "User" + String.format("%03d", count++);
        this.email = email;
        this.Gender = Gender;
        this.username = username;
        this.password = this.hashPassword(password);
        if (this.password == null || this.password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Unable to hash password", "Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Password hashing failed. User account cannot be created.");
        }
        this.date = date.format(DATE_FORMAT);
        this.makeOffline();
        friends = new ArrayList<>();
        blocked = new ArrayList<>();
        requests  = new ArrayList<>();
        joinedGroups = new ArrayList<>(); 

    }

    public static String hashPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = messageDigest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null, "Unable to hash password");
            return null;
        }
    }
    
    
    public boolean sendFriendRequest(String receiver)
    {
        try{
        
        for (UserAccount user : LOGIN.database.getUsers()) {
            if (user.getUsername().equals(receiver))
            {
                for(int j = 0; j < user.requests.size(); j++)
                {
                    if(user.requests.get(j).equals(this.getUsername()+"_"+user.getUsername()+"pending"))
                    {
                        JOptionPane.showMessageDialog(null,"You have already sent friend request to "+user.getUsername());
                        return false;
                    }
                }
                
              //  this.requests.add(new FriendRequests(this,user).getId()+"pending");
                user.requests.add(new FriendRequests(this,user).getId() + "pending");
                //JOptionPane.showMessageDialog(null,"Friend request sent from " + this.getUsername() + " to " + user.getUsername());
                LOGIN.database.saveToFile();
                return true;
            }
        }
        
         //JOptionPane.showMessageDialog(null,"No User found !");         
        return false;
        
        }catch(IllegalArgumentException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public void approveRequest(String username) {
        
        for (int i = 0; i < this.requests.size(); i++) {
            String traversed = requests.get(i);
            UserAccount user;
            if (traversed.equals(username+"_"+this.getUsername()+ "pending")) {
                user = LOGIN.database.getRecordWithName(username); 
                this.friends.add(user.getUsername());
                user.friends.add(this.getUsername());
                requests.remove(i);
                for(int j = 0; j < user.requests.size(); j++)
                {
                    if(user.requests.get(j).equals(username+"_"+this.getUsername()+"pending"))
                    {
                        user.requests.remove(j);
                        break;
                    }
                }
                LOGIN.database.saveToFile();
                //JOptionPane.showMessageDialog(null,"You are now friends with " + username,"Success",JOptionPane.INFORMATION_MESSAGE);     
                return;
             }
        }
        JOptionPane.showMessageDialog(null,"There is no friend request from this person","Error",JOptionPane.ERROR_MESSAGE);

    }
    
    
    public void declineRequest(String username)
    {
        for (int i = 0; i < this.requests.size(); i++) {
            String traversed = requests.get(i);
            UserAccount user;
            if (traversed.equals(username+"_"+this.getUsername()+"pending")) {
                user = LOGIN.database.getRecordWithName(username); 
                requests.remove(i);
                JOptionPane.showMessageDialog(null,"You declined " + username,"Success",JOptionPane.INFORMATION_MESSAGE);
                for (int j = 0; j < user.requests.size(); j++) {
                    if(user.requests.get(j).equals(username+"_"+this.getUsername()+"pending"))
                    {
                        user.requests.set(j,username+"_"+this.getUsername()+"declined");
                        break;
                    }
                }
                LOGIN.database.saveToFile();
                return;
            
        }}
        
        JOptionPane.showMessageDialog(null,"There is no friend request from this person","Error",JOptionPane.ERROR_MESSAGE);

    }
        
    
    
    
    public void showFriendRequests() {
        if (requests.size() != 0) {
            for (int i = 0; i < requests.size(); i++) {
                System.out.println("You have friend Request from " + requests.get(i));
            }

        } else {
            System.out.println("No Friend Requests to be shown");
        }
    }
    
    
    
    public void showFriends() {
        for (String s : this.friends)
        {  
            System.out.println(s);
        }
    }
    
    
    public boolean isFriends(String username) {
        for(String s:this.friends)
        {
            if(s.equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean isBlocked(String username) {
        for (String user: this.blocked) {
            if (user.equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean blockUser(String blocked) {

        for (String user : this.blocked) {
           if(blocked.equals(user))
           {
               System.out.println("Already blocked");
               return false;
           }
        }
        
        for(UserAccount user : LOGIN.database.getUsers())
        {
            if(blocked.equals(user.getUsername()))
            {
                this.blocked.add(blocked);              
                if(isFriends(blocked))
                {
                    this.removeFriend(blocked);
                }   
                System.out.println("Blocked successfully");
                LOGIN.database.saveToFile(); 
                return true;
            }
        }
        return false;
     }  
    
    
    
    
    
    
    public void removeFriend(String removed) {
        for (int i = 0; i < this.friends.size(); i++) {
            String s = friends.get(i);
            UserAccount user;
            if (s.equals(removed)) {
                this.friends.remove(i);
                user = LOGIN.database.getRecordWithName(removed);
                for(int j = 0; j < user.friends.size();j++)
                {
                    if(user.friends.get(j).equals(this.username))
                    {
                        user.friends.remove(j);
                        //this.blocked.add(removed);
                        LOGIN.database.saveToFile();
                        break;
                    }
                }
                System.out.println("Removed");
                return;
            }
        }
        System.out.println("Not already in your Friends ");
    }
    
    
    public ArrayList<UserAccount> getFriendSuggestions() {
         ArrayList<UserAccount> friendSuggestions = new ArrayList<>();
        
        if (LOGIN.database.getUsers() == null || LOGIN.database.getUsers().isEmpty()) {
        return friendSuggestions;  
        }
  
       

        for (UserAccount user : LOGIN.database.getUsers()) {
            if (!user.getUserID().equals(this.getUserID()) && !isFriends(user.getUsername()) && !isBlocked(user.getUsername())) {
                if (!friendSuggestions.contains(user)) {
                    friendSuggestions.add(user);
                }
            }
        }

        return friendSuggestions;
    }
      

    public String getUsername() {
        return username;
    }

    public void makeOnline() {
        this.status = "online";
    }

    public void makeOffline() {
        this.status = "offline";
    }

    public String getSearchKey() {
        return this.userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    

    public LocalDate getDate() {
        return LocalDate.parse(this.date, DATE_FORMAT);
    }

    public void setDate(LocalDate date) {
        this.date = date.format(DATE_FORMAT);
    }

    public String getStatus() {
        return status;
    }

    public String getUserID() {
        return userID;
    }

    public ArrayList<UserAccount> getFriends() {
        ArrayList <UserAccount> users = new ArrayList<>();
        if (this.friends == null || this.friends.isEmpty()) {
        return users;  
        }
        for(int i = 0; i < this.friends.size(); i++)
        {
            users.add(LOGIN.database.getRecordWithName(friends.get(i)));
        }
        return users;
    }

    public ProfileManagement getProfile() {
        return profile;
    }

    public ArrayList<String> getBlocked() {
        return blocked;
    }

    public ArrayList<UserAccount> getRequests() {
        ArrayList <UserAccount> users = new ArrayList<>();
        if (this.requests == null || this.requests.isEmpty()) {
        return users;  
        }
        for(int i = 0; i < this.requests.size(); i++)
        {
            String s = requests.get(i);
            int index = s.indexOf('_');
            int target = s.indexOf('_', index+1);
            System.out.println("Test   "+LOGIN.database.getRecordWithName(s.substring(0, target)));
            users.add(LOGIN.database.getRecordWithName(s.substring(0, target)));
        }
        //System.out.println("users"+users.get(0));
        return users;
    }

    
    public ArrayList<Group> getJoinedGroups() {
        
        
       // return this.joinedGroups;
        ArrayList<Group> groups = LOGIN.groupdatabase.getgroups();
        ArrayList <Group> joinedGroups = new ArrayList<>();
        if (groups == null || groups.isEmpty()) {
        return joinedGroups;  
        }
        for(Group g : groups)
        {
            for(UserAccount user : g.getObjectUser())
            {
                System.out.println("Check here !!!!!!!!!"+user.username);
                if(user.userID.equals(this.userID))
                {
                    joinedGroups.add(g);
                    break;
                }
            }
            
        }
        //System.out.println("users"+users.get(0));
        return joinedGroups;
    }
    
    
    public boolean isJoinedGroup(String groupname)
    {
        ArrayList<Group> joinedgroups = LOGIN.database.getCurrentUser().getJoinedGroups();
      //  ArrayList <Group> joinedGroups = new ArrayList<>();
        if (joinedgroups == null || joinedgroups.isEmpty()) {
        return false;  
        }
        for(Group g : joinedgroups)
        {
            if(g.getName().equals(groupname))
            {
                return true;
            }
            
        }
        //System.out.println("users"+users.get(0));
        return false;
    }
    
    
    public boolean isAdminGroup(String groupname)
    {
        Group group = LOGIN.groupdatabase.getRecord(groupname);
        if(group.getPrimaryAdmin().equals(this.username))
        {
            return true;
        }
        return false;
    }
    
    
    
}