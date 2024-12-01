/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.time.LocalDate;
import java.security.*;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
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
    
    
    
    protected static String hashPassword(String password) {
        try { 
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = messageDigest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null,"Unable to hash password");
            return null;
        }
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
    
    
    
    
    public LocalDate getDate() {
        return LocalDate.parse(this.date, DATE_FORMAT); 
    }

    public void setDate(LocalDate date) {
        this.date = date.format(DATE_FORMAT);
    } 
    
    
    
    
    
}
