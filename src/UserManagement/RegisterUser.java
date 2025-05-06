package UserManagement;

public class RegisterUser {
    public static boolean register(String username, String password) {
        if (UserDatabase.users.containsKey(username)) {
            System.out.println("Username already exists!");
            return false;
        }
        UserDatabase.users.put(username, new User(username, password));
        UserDatabase.save(); // persist change
        System.out.println("User registered successfully!");
        return true;
    }

}
