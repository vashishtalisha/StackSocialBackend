package UserManagement;

import java.util.ArrayList;
import java.util.List;

public class SearchByName {
    public static List<String> search(String keyword) {
        List<String> matchingUsers = new ArrayList<>();
        for (String username : UserDatabase.users.keySet()) {
            if (username.toLowerCase().contains(keyword.toLowerCase())) {
                matchingUsers.add(username);
            }
        }
        return matchingUsers;
    }
}
