/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import FrontEnd.LOGIN;

/**
 *
 * @author Mostafa
 */
public class FriendRequests {

    private String id;
    private UserAccount receiver;
    private UserAccount sender;
    private String status;

    public FriendRequests(UserAccount sender, UserAccount receiver) {
        this.id = sender.getUserID()+receiver.getUserID();
        this.receiver = receiver;
        this.sender = sender;
        this.status = "Pending";
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }
    
    
    
    public String LineRepresentation(){
    String line = this.sender.getUsername()+","+this.status;
    return line;
    }
    
}
