package BackEnd;

import java.util.ArrayList;
import java.util.List;

public class SearchFunctionality {

    private UserDatabase userDatabase;
    private GroupDatabase groupDatabase;
    private UserAccount currentUser;

    public SearchFunctionality(UserDatabase userDatabase, GroupDatabase groupDatabase, UserAccount currentUser) {
        this.userDatabase = userDatabase;
        this.groupDatabase = groupDatabase;
        this.currentUser = currentUser;
    }

    public ArrayList<UserAccount> searchUsers(String username) {// Search for users by username
        ArrayList<UserAccount> results = new ArrayList<>();
        for (UserAccount user : userDatabase.getUsers()) {
            if (user.getUsername().toLowerCase().contains(username.toLowerCase())) {
                results.add(user);
            }
        }
        return results;
    }

    public ArrayList<Group> searchGroups(String groupName) {// Search for groups by group name
        ArrayList<Group> results = new ArrayList<>();
        for (Group group : groupDatabase.getgroups()) {
            if (group.getName().toLowerCase().contains(groupName.toLowerCase())) {
                results.add(group);
            }
        }
        return results;
    }
}