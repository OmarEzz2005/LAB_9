package BackEnd;


import BackEnd.UserAccount;
import FrontEnd.LOGIN;
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
    private UserDatabase database = LOGIN.database;

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

    public boolean sendFriendRequest(String receiver) {
        for (UserAccount user : database.getUsers()) {
            if (user.getUsername().equals(receiver)) {
                user.requests.add(new FriendRequests(current, user));
                System.out.println("Friend request sent from " + current.getUsername() + " to " + user.getUsername());
                return true;
            }
        }
        return false;
    }

    public void approveRequest(String username) {
        for (int i = 0; i < friendRequests.size(); i++) {
            FriendRequests traversed = friendRequests.get(i);
            if (traversed.getSender().getUsername().equals(username) && traversed.getStatus().equals("Pending")) {
                this.friends.add(traversed.getSender());
                traversed.getSender().friends.add(current);
                JOptionPane.showMessageDialog(null,"You are now friends with " + traversed.getSender().getUsername(),"Success",JOptionPane.INFORMATION_MESSAGE);
                friendRequests.remove(i);
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"There is no friend request from this person","Error",JOptionPane.ERROR_MESSAGE);
    }

    public void declineRequest(String username) {
        for (int i = 0; i < friendRequests.size(); i++) {
            FriendRequests traversed = friendRequests.get(i);
            if (traversed.getSender().getUsername().equals(username) && traversed.getStatus().equals("Pending")) {
                traversed.setStatus("Declined");
                JOptionPane.showMessageDialog(null,"You declined " + username + " as a friend","Success",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"There is no friend request from this person","Error",JOptionPane.ERROR_MESSAGE);
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

    public void removeFriend(String removed) {
        for (UserAccount friend : database.getUsers()) {
            if (friend.getUsername().equals(removed)) {
                this.friends.remove(friend);
                friend.friends.remove(this.current);
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

    public boolean blockUser(String blocked) {

        for (UserAccount user : database.getUsers()) {
            if (user.getUsername().equals(blocked)) {
                this.blockedUsers.add(user);
                if(isFriends(blocked))
                    this.removeFriend(blocked);
                System.out.println("Blocked Successfully");
                return true;
            }
        }
        return false;
    }

    public ArrayList<UserAccount> getFriendSuggestions() {
        ArrayList<UserAccount> friendSuggestions = new ArrayList<>();

        for (UserAccount user : database.getUsers()) {
            if (!user.getUserID().equals(current.getUserID()) && !isFriends(user.getUsername()) && !isBlocked(user.getUsername())) {
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

    public boolean isFriends(String username) {
        for (UserAccount friend : friends) {
            if (username.equals(friend.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean isBlocked(String username) {
        for (UserAccount blocked : blockedUsers) {
            if (username.equals(blocked.getUsername())) {
                return true;
            }
        }
        return false;
    }

}
