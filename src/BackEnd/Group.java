/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

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
    private String Discription;
    private String GroupPhotoPath;
    private String PrimaryAdmin;
    private ArrayList<String> OtherAdmins=new ArrayList<>();
    private ArrayList<String> Users=new ArrayList<>();

    public Group(String name, String Discription, String GroupPhotoPath, String PrimaryAdmin) {
        this.ID="Group"+String.format("%.3d", count++);
        this.name = name;
        this.Discription = Discription;
        this.GroupPhotoPath = GroupPhotoPath;
        this.PrimaryAdmin = PrimaryAdmin;
        
        this.OtherAdmins=new ArrayList<>();
        this.Users=new ArrayList<>();
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
    
}
