/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

/**
 *
 * @author lenovo
 */




import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Mostafa
 */
public class FriendManagment {

    private UserAccount current;
    private ArrayList<FriendRequests> friendRequests = new ArrayList<>();
    private ArrayList<UserAccount> friends = new ArrayList<>();
    private ArrayList<UserAccount> blockedUsers = new ArrayList<>();

    public FriendManagment(UserAccount current, ArrayList<FriendRequests> friendRequests, ArrayList<UserAccount> blockedUsers, ArrayList<UserAccount> friends) {
        this.current = current;
        this.friendRequests = friendRequests;
        this.blockedUsers = blockedUsers;
        this.friends = friends;
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
                traversed.getSender().friendManagment.friends.add(current);
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
        for (UserAccount friend : friends) {
            if (friend.getUserID().equals(removed.getUserID())) {
                friends.remove(friend);
                removed.friendManagment.removeFriend(this.current);
                return;
            }
        }
        System.out.println("Not already in your Friends ");
    }

    public ArrayList<String> getFriendsWithStatus() {
        ArrayList<String> friendsWithStatus = new ArrayList();
        for (UserAccount friend : friends) {
            friendsWithStatus.add(friend.getUsername() + "," + friend.getStatus());
        }

        return friendsWithStatus;
    }

    public void blockUser(UserAccount blocked) {

        for (UserAccount user : allusers) {
            if (user.getUserID().equals(blocked.getUserID())) {
                this.blockedUsers.add(blocked);
            }
        }

    }

    public ArrayList<UserAccount> getFriendSuggestions() {
        ArrayList<UserAccount> friendSuggestions = new ArrayList<>();

        for (UserAccount user : UserAccount.allusers) {
            if (!user.getUserID().equals(current.getUserID()) && !isFriends(user.getUserID()) && !isBlocked(user.getUserID())) {
                if (!friendSuggestions.contains(user)) {
                    friendSuggestions.add(user);
                }
            }
        }

        return friendSuggestions;
    }

    public void showFriends() {
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
