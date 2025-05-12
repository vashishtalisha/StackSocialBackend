

import UserManagement.UserDatabase;
import PostManagement.PostDatabase;

import java.util.*;
import java.io.Console;


public class AdminPanel {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    public static void adminLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter admin username: ");
        String username = sc.nextLine();

        String password;
        Console console = System.console();

        if (console != null) {
            char[] passwordChars = console.readPassword("Enter admin password: ");
            password = new String(passwordChars);
        } else {
            // Fallback when using IntelliJ or other IDEs that don't support System.console()
            System.out.print("Enter admin password (visible): ");
            password = sc.nextLine();
        }

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Admin login successful!");
            adminMenu();
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }


    private static void adminMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View all users");
            System.out.println("2. Delete a user");
            System.out.println("0. Logout");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewAllUsers();
                    break;
                case 2:
                    System.out.print("Enter username to delete: ");
                    String userToDelete = sc.nextLine();
                    deleteUser(userToDelete);
                    break;
                case 0:
                    System.out.println("Logging out of admin panel.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void viewAllUsers() {
        if (UserDatabase.users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("Registered users:");
            for (String username : UserDatabase.users.keySet()) {
                System.out.println("- " + username);
            }
        }
    }

    private static void deleteUser(String username) {
        if (UserDatabase.users.remove(username) != null) {
            PostDatabase.userPosts.remove(username);
            PostDatabase.allPosts.removeIf(post -> post.getUsername().equals(username));
            UserManagement.UserDataStorage.saveUser();
            PostManagement.PostDataStorage.savePosts();
            System.out.println("User '" + username + "' and their posts have been deleted.");
        } else {
            System.out.println("User not found.");
        }
    }
}
