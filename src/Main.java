import UserManagement.*;
import PostManagement.*;
import DirectMessages.*;
import NotificationsSystem.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currentUser = null;

        while (true) {
            System.out.println("\n=== StackSocial MAIN MENU ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter username: ");
                    String regUser = sc.nextLine();
                    System.out.print("Enter password: ");
                    String regPass = sc.nextLine();
                    if (RegisterUser.register(regUser, regPass)) {
                        NotificationService.addNotification(regUser, "Welcome to StackSocial!");
                    }
                }
                case 2 -> {
                    System.out.print("Enter username: ");
                    String loginUser = sc.nextLine();
                    System.out.print("Enter password: ");
                    String loginPass = sc.nextLine();
                    if (LoginUser.login(loginUser, loginPass)) {
                        currentUser = loginUser;
                        NotificationService.getNotifications(currentUser);
                        loggedInMenu(sc, currentUser);
                    }
                }
                case 3 -> {
                    System.out.println("Exiting StackSocial. Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void loggedInMenu(Scanner sc, String currentUser) {
        int option;
        do {
            System.out.println("\n=== Logged In Menu (" + currentUser + ") ===");
            System.out.println("1. Manage Posts");
            System.out.println("2. Direct Messages");
            System.out.println("3. View Profile");
            System.out.println("4. Search Users");
            System.out.println("5. Notifications");
            System.out.println("6. Logout");
            System.out.print("Enter option: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> postMenu(sc, currentUser);
                case 2 -> dmMenu(sc, currentUser);
                case 3 -> ViewProfile.view(currentUser);
                case 4 -> {
                    System.out.print("Enter search keyword: ");
                    String keyword = sc.nextLine();
                    var results = SearchByName.search(keyword);
                    if (results.isEmpty()) System.out.println("No users found.");
                    else results.forEach(name -> System.out.println("- " + name));
                }
                case 5 -> {
                    NotificationService.getNotifications(currentUser);
                    NotificationService.markAllAsRead(currentUser);
                }
                case 6 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid option.");
            }
        } while (option != 6);
    }

    private static void postMenu(Scanner sc, String user) {
        int choice;
        do {
            System.out.println("\n=== Post Management ===");
            System.out.println("1. Create Post");
            System.out.println("2. Edit Post");
            System.out.println("3. Delete Post");
            System.out.println("4. View My Posts");
            System.out.println("5. Like Post");
            System.out.println("6. Comment on Post");
            System.out.println("7. Back");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter content: ");
                    String content = sc.nextLine();
                    CreatePost.create(user, content);
                }
                case 2 -> {
                    System.out.print("Enter Post ID to edit: ");
                    int postId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New content: ");
                    String newContent = sc.nextLine();
                    EditPost.edit(postId, newContent, user);
                }
                case 3 -> {
                    System.out.print("Enter Post ID to delete: ");
                    int postId = sc.nextInt();
                    DeletePost.delete(postId, user);
                }
                case 4 -> ViewOwnPosts.view(user);
                case 5 -> {
                    System.out.print("Enter Post ID to like: ");
                    int postId = sc.nextInt();
                    LikePost.like(postId, user);
                }
                case 6 -> {
                    System.out.print("Enter Post ID to comment: ");
                    int postId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Comment: ");
                    String comment = sc.nextLine();
                    CommentPost.comment(postId, comment);
                }
                case 7 -> {}
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 7);
    }

    private static void dmMenu(Scanner sc, String user) {
        int option;
        do {
            System.out.println("\n=== Direct Messages ===");
            System.out.println("1. Send Message");
            System.out.println("2. View Conversation");
            System.out.println("3. Back");
            System.out.print("Choice: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("To: ");
                    String receiver = sc.nextLine();
                    System.out.print("Message: ");
                    String msg = sc.nextLine();
                    DMService.sendMessage(user, receiver, msg);
                    NotificationService.addNotification(receiver, "New message from " + user);
                }
                case 2 -> {
                    System.out.print("With: ");
                    String other = sc.nextLine();
                    DMService.viewMessages(user, other);
                }
                case 3 -> {}
                default -> System.out.println("Invalid option.");
            }
        } while (option != 3);
    }
}
