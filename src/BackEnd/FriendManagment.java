/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author lenovo
 */




import FrontEnd.LOGIN;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;


/**
 *
 * @author Mostafa
 */
public class FriendManagment {
    
    private UserDatabase data = LOGIN.database;
    private UserAccount current;
    private ArrayList<FriendRequests> friendRequests = new ArrayList<>();
    private ArrayList<UserAccount> friends = new ArrayList<>();
    private ArrayList<UserAccount> blockedUsers = new ArrayList<>();

    public FriendManagment( ArrayList<FriendRequests> friendRequests, ArrayList<UserAccount> blockedUsers) {
        this.current = data.getCurrentUser();
        this.friendRequests = friendRequests;
        this.blockedUsers = blockedUsers;
        this.friends = current.getFriends();
    }

    public ArrayList<FriendRequests> getFriendRequests() {
        ArrayList<FriendRequests> pendingRequests = new ArrayList();
        for (int i = 0; i < friendRequests.size(); i++) {
            FriendRequests traversed = friendRequests.get(i);
            if (traversed.getStatus().equals("Pending")) {
                pendingRequests.add(traversed);
            }

        }
        return pendingRequests;
    }

    public void sendFriendRequest(UserAccount receiver) {
        if (isFriends(receiver.getUserID())) {
            System.out.println("You are already friends.");
            return;
        }
        friendRequests.add(new FriendRequests(current, receiver));
        JOptionPane.showMessageDialog(null,"Friend request sent from " + current.getUsername() + " to " + receiver.getUsername(),"Info message",JOptionPane.INFORMATION_MESSAGE);
    }

    public void approveRequest(String username) {
        for (int i = 0; i < friendRequests.size(); i++) {
            FriendRequests traversed = friendRequests.get(i);
            if (traversed.getSender().getUsername().equals(username) && traversed.getStatus().equals("Pending")) {
                this.friends.add(traversed.getSender());
                
                System.out.println("You are now friends with " + traversed.getSender().getUsername());
                friendRequests.remove(i);
                return;
            }
        }
        System.out.println("There is no friend request from this person");
    }

    public void declineRequest(String username) {
        for (int i = 0; i < friendRequests.size(); i++) {
            FriendRequests traversed = friendRequests.get(i);
            if (traversed.getSender().getUsername().equals(username) && traversed.getStatus().equals("Pending")) {
                traversed.setStatus("Declined");
                System.out.println("You declined " + username + " as a friend");
                return;
            }
        }
        System.out.println("There is no friend request from this person");
    }

    public void showFriendRequests() {
        ArrayList<FriendRequests> pendingRequests = this.getFriendRequests();
        if (pendingRequests.size() != 0) {
            for (int i = 0; i < pendingRequests.size(); i++) {
                System.out.println("You have friend Request from " + pendingRequests.get(i).getSender().getUsername());
            }

        } else {
            System.out.println("No Friend Requests to be shown");
        }
    }

    public void removeFriend(UserAccount removed) {
        if(friends.size() <= 0)
        {
            System.out.println("No friends");
            return;
        }
    Iterator<UserAccount> iterator = friends.iterator();
    while (iterator.hasNext()) {
        UserAccount friend = iterator.next();
        if (friend.getUserID().equals(removed.getUserID())) {
            iterator.remove();
            System.out.println("Removed " + removed.getUsername() + " from friends");
            return;
        }
    }
    System.out.println("Not in your friends list");
    }

    public ArrayList<String> getFriendsWithStatus() {
        if(friends.size() <= 0)
        {
            System.out.println("No friends");
            return null;
        }
        ArrayList<String> friendsWithStatus = new ArrayList();
        for (UserAccount friend : friends) {
            friendsWithStatus.add(friend.getUsername() + "," + friend.getStatus());
        }

        return friendsWithStatus;
    }

    public void blockUser(UserAccount blocked) {
        if (isBlocked(blocked.getUserID())) {
        System.out.println(blocked.getUsername() + " is already blocked.");
        return;
        }

        for (UserAccount user : data.getUsers()) {
            if (user.getUserID().equals(blocked.getUserID())) {
                this.blockedUsers.add(blocked);
            }
        }

    }

    public ArrayList<UserAccount> getFriendSuggestions() {
        ArrayList<UserAccount> friendSuggestions = new ArrayList<>();

        for (UserAccount user : data.getUsers()) {
            if (!user.getUserID().equals(current.getUserID()) && !isFriends(user.getUserID()) && !isBlocked(user.getUserID())) {
                if (!friendSuggestions.contains(user)) {
                    friendSuggestions.add(user);
                }
            }
        }

        return friendSuggestions;
    }

    public void showFriends() {
        if(friends.size() <= 0)
        {
            System.out.println("No friends");
            return;
        }
        for (UserAccount friend : friends) {
            System.out.println(friend.getUsername());
        }
    }

    private boolean isFriends(String userId) {
        for (UserAccount friend : friends) {
            if (userId.equals(friend.getUserID())) {
                return true;
            }
        }
        return false;
    }

    private boolean isBlocked(String userId) {
        for (UserAccount blocked : blockedUsers) {
            if (userId.equals(blocked.getUserID())) {
                return true;
            }
        }
        return false;
    }

}
