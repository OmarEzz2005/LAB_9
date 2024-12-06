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
    protected ArrayList <String> friends = new ArrayList<>();
    protected ArrayList <String> blocked  = new ArrayList<>();
    protected ArrayList <String> requests  = new ArrayList<>();
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
        this.makeOnline();

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
        for (UserAccount user : LOGIN.database.getUsers()) {
            if (user.getUserID().equals(receiver))
            {
                this.requests.add(user.getUserID());
                JOptionPane.showMessageDialog(null,"Friend request sent from " + this.getUsername() + " to " + user.getUsername());
                LOGIN.database.saveToFile();
                return true;
            }
        }
         JOptionPane.showMessageDialog(null,"No User found !");         
        return false;
    }
    
    public void approveRequest(String username) {
        
        for (int i = 0; i < this.requests.size(); i++) {
            String traversed = requests.get(i);
            if (traversed.equals(username)) {
                this.friends.add(this.getUserID());
                requests.remove(i);
                LOGIN.database.saveToFile();
                JOptionPane.showMessageDialog(null,"You are now friends with " + username,"Success",JOptionPane.INFORMATION_MESSAGE);
                for (UserAccount user : LOGIN.database.getUsers()) {
            if (user.getUsername().equals(username))
            {
                user.friends.add(this.getUserID());
                LOGIN.database.saveToFile();
            }
                }
                return;
            
        }}
        JOptionPane.showMessageDialog(null,"There is no friend request from this person","Error",JOptionPane.ERROR_MESSAGE);

    }
    
    
    public void declineRequest(String username)
    {
        for (int i = 0; i < this.requests.size(); i++) {
            String traversed = requests.get(i);
            if (traversed.equals(username)) {
                requests.remove(i);
                LOGIN.database.saveToFile();
                JOptionPane.showMessageDialog(null,"You declined " + username,"Success",JOptionPane.INFORMATION_MESSAGE);
                for (UserAccount user : LOGIN.database.getUsers()) {
            if (user.getUsername().equals(username))
            {
                LOGIN.database.saveToFile();
            }
                }
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
        ArrayList <UserAccount> friendlist=LOGIN.database.getUsers();
        for (UserAccount user:friendlist)
        {  
            System.out.println(user.getUsername());
        }
    }
    
    
    public boolean isFriends(String username) {
        ArrayList <UserAccount> friendlist=LOGIN.database.getUsers();
        for (UserAccount user:friendlist)
        {  if(username.equals(user.getUsername()))
                {
                    return true;
                }
             else 
              {
                  return false;
               }
        }
        return false;
    }

    public boolean isBlocked(String username) {
        for (String user: blocked) {
            if (user.equals(blocked)) {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean blockUser(String blocked) {

        for (UserAccount user : LOGIN.database.getUsers()) {
           if(blocked.contains(user.getUsername()))
           {
               return false;
           }
            if (user.getUsername().equals(blocked)) {
                this.blocked.add(blocked);
                if(isFriends(blocked))
                    this.removeFriend(blocked);
                System.out.println("Blocked Successfully");
                return true;
            }
        }
        return false;
     }  
    
    
    
    
    
    
    public void removeFriend(String removed) {
        for (UserAccount friend : LOGIN.database.getUsers()) {
            if (friend.getUsername().equals(removed)) {
                this.friends.remove(friend);
                friend.friends.remove(this);
                return;
            }
        }
        System.out.println("Not already in your Friends ");
    }
    
    
   /* public ArrayList<UserAccount> getFriendSuggestions() {
        ArrayList<UserAccount> friendSuggestions = new ArrayList<>();

        for (UserAccount user : LOGIN.database.getUsers()) {
            if (!user.getUserID().equals(this.getUserID()) && !isFriends(user.getUsername()) && !isBlocked(user.getUsername())) {
                if (!friendSuggestions.contains(user)) {
                    friendSuggestions.add(user);
                }
            }
        }

        return friendSuggestions;
    }*/
    
    
    public ArrayList<String> MutualFriends() {
        Random random = new Random();
        int count = 0;

        ArrayList<String> UserFriendList = this.getFriends();
        ArrayList<String> UserFriendFriendList = new ArrayList<>();
        ArrayList<String> mutualFriends = new ArrayList<>();

        int x;

        for (String friend : UserFriendList) {
            UserFriendFriendList = friend;
            x = random.nextInt(UserFriendFriendList.size());
            for (UserAccount FofF : UserFriendFriendList) {

                do {
                    count++;
                    if (!UserFriendList.contains(FofF) && !FofF.equals(this) && mutualFriends.contains(FofF)) {
                        mutualFriends.add(UserFriendFriendList.get(x));
                    }
                } while (count < 3);

            }

        }
        return mutualFriends;
    }

    public ArrayList<UserAccount> getFriendSuggestions() {
        DefaultListModel<String> model = new DefaultListModel<>();
        ArrayList<UserAccount> suggestedFriends = new ArrayList<>();
        ArrayList<UserAccount> DataBaseusers = new ArrayList<>();
        if (this.getFriends() == null || this.getFriends().isEmpty()) {
            Random random = new Random();
            int count = 0;
            int x = random.nextInt(DataBaseusers.size());
            do {
                count++;
                suggestedFriends.add(DataBaseusers.get(x));
            } while (count < 5);
        } else {
            suggestedFriends = this.MutualFriends();
        }
        return suggestedFriends;

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

    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
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

    public ArrayList<String> getFriends() {
        return friends;
    }

    public ProfileManagement getProfile() {
        return profile;
    }

    public ArrayList<String> getBlocked() {
        return blocked;
    }

    public ArrayList<String> getRequests() {
        return requests;
    }

}