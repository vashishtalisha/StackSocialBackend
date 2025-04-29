package UserManagement;

public class LoginUser {
    public static boolean login(String username, String password) {
        if (!UserDatabase.users.containsKey(username)) {
            System.out.println("No such user found!");
            return false;
        }
        User user = UserDatabase.users.get(username);
        if (user.getPassword().equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Incorrect password!");
            return false;
        }
    }
}
