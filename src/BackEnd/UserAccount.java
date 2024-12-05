/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

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
    private ArrayList <UserAccount> friends;

    public UserAccount(String email, String username,String Gender, String password, LocalDate date) {
        this.userID = "User" + String.format("%03d", count++);
        this.email = email;
        this.Gender = Gender;
        this.username = username;
        this.password = this.hashPassword(password);
        if(this.password == null || this.password.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Unable to hash password","Error",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null,"Unable to hash password");
            return null;
        }
    }
    

    public String getUsername() {
        return username;
    }
    
    
    public void makeOnline()
    {
        this.status = "online";
    }
    
    public void makeOffline()
    {
        this.status = "offline";
    }
    
    public String getSearchKey()
    {
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
        return friends;
    }
    
    
    
    
    public ArrayList<UserAccount> MutualFriends()
    {
        Random random=new Random();
        int count=0;
        
        ArrayList <UserAccount> UserFriendList =this.getFriends();
        ArrayList <UserAccount> UserFriendFriendList = new ArrayList<>();
        ArrayList<UserAccount> mutualFriends = new ArrayList<>();
        
        int x; 
    
        for(UserAccount friend: UserFriendList)
        {
            UserFriendFriendList=friend.getFriends();
            x = random.nextInt(UserFriendFriendList.size());
            for (UserAccount FofF: UserFriendFriendList)
            {
                  
              do{
                   count++;
                   if(!UserFriendList.contains(FofF)&&!FofF.equals(this)&&mutualFriends.contains(FofF))
                     {
                         mutualFriends.add(UserFriendFriendList.get(x));
                     }
                }while (count<3);
                
            }
            
        }
        return mutualFriends;
    }
    public ArrayList<UserAccount> SuggestedFriends()
    {
        DefaultListModel<String> model = new DefaultListModel<>();
        ArrayList<UserAccount> suggestedFriends = new ArrayList<>();
        ArrayList<UserAccount> DataBaseusers = new ArrayList<>();
        if(this.getFriends()==null||this.getFriends().isEmpty())
        {
            Random random=new Random();
            int count=0;
            int x=random.nextInt(DataBaseusers.size());
            do{
                count++;
                suggestedFriends.add(DataBaseusers.get(x));
            }while(count<5);
        }
        else
        {
            suggestedFriends=this.MutualFriends();
        }
        return suggestedFriends;

    }
    
    
    
    
    
}
