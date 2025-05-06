package UserManagement;

import java.util.HashMap;

public class UserDatabase {
    public static HashMap<String, User> users = UserDataStorage.loadUsers();

    public static void save() {
        UserDataStorage.saveUsers(users);
    }
}
