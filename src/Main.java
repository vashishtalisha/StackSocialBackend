//import java.util.*;
//
//public class Main {
//
//    private static String loggedInUser = null;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("\n=== Post Management System ===");
//            if (loggedInUser == null) {
//                System.out.println("1. Register");
//                System.out.println("2. Login");
//            } else {
//                System.out.println("Logged in as: " + loggedInUser);
//                System.out.println("3. Create Post");
//                System.out.println("4. Edit Post");
//                System.out.println("5. View My Posts");
//                System.out.println("6. Like Post");
//                System.out.println("7. Comment on Post");
//                System.out.println("8. Send Message");
//                System.out.println("9. View Conversations");
//                System.out.println("10. View Notifications");
//                System.out.println("11. Add Notification");
//                System.out.println("12. Exit");
//            }
//            System.out.print("Enter choice: ");
//            int choice = sc.nextInt();
//            sc.nextLine(); // consume newline
//
//            if (loggedInUser == null) {
//                // User not logged in, show login/register options
//                switch (choice) {
//                    case 1:
//                        System.out.print("Enter username: ");
//                        String username = sc.nextLine();
//                        System.out.print("Enter password: ");
//                        String password = sc.nextLine();
//                        if (UserManager.isUserExists(username)) {
//                            System.out.println("User already exists.");
//                        } else {
//                            if (UserManager.registerUser(username, password)) {
//                                System.out.println("Registration successful!");
//                            } else {
//                                System.out.println("Registration failed.");
//                            }
//                        }
//                        break;
//
//                    case 2:
//                        System.out.print("Enter username: ");
//                        username = sc.nextLine();
//                        System.out.print("Enter password: ");
//                        password = sc.nextLine();
//                        if (UserManager.authenticateUser(username, password)) {
//                            loggedInUser = username;
//                            System.out.println("Login successful!");
//                        } else {
//                            System.out.println("Invalid username or password.");
//                        }
//                        break;
//
//                    default:
//                        System.out.println("Invalid choice.");
//                }
//            } else {
//                // User logged in, show post management options
//                switch (choice) {
//                    case 3:
//                        // Create a post
//                        System.out.print("Enter content: ");
//                        String content = sc.nextLine();
//                        Post post = new Post(loggedInUser, content);
//                        PostManager.savePost(post);
//                        break;
//
//                    case 4:
//                        // Edit a post
//                        System.out.print("Enter Post ID to edit: ");
//                        int postId = sc.nextInt();
//                        sc.nextLine();
//                        System.out.print("Enter new content: ");
//                        String newContent = sc.nextLine();
//                        PostManager.editPost(postId, newContent, loggedInUser);
//                        break;
//
//                    case 5:
//                        // View posts of the logged-in user
//                        List<Post> posts = PostManager.loadPosts();
//                        for (Post p : posts) {
//                            if (p.getUsername().equals(loggedInUser)) {
//                                p.viewPost();
//                            }
//                        }
//                        break;
//
//                    case 6:
//                        // Like a post
//                        System.out.print("Enter Post ID to like: ");
//                        postId = sc.nextInt();
//                        sc.nextLine();
//                        PostManager.likePost(postId, loggedInUser);
//                        break;
//
//                    case 7:
//                        // Comment on a post
//                        System.out.print("Enter Post ID to comment on: ");
//                        postId = sc.nextInt();
//                        sc.nextLine();
//                        System.out.print("Enter comment: ");
//                        String comment = sc.nextLine();
//                        PostManager.commentOnPost(postId, comment);
//                        break;
//
//                    case 8:
//                        // Send a message
//                        System.out.print("Sender: ");
//                        String sender = loggedInUser;
//                        System.out.print("Receiver: ");
//                        String receiver = sc.nextLine();
//                        System.out.print("Message: ");
//                        String messageContent = sc.nextLine();
//                        DMService.sendMessage(sender, receiver, messageContent);
//                        break;
//
//                    case 9:
//                        // View conversation
//                        System.out.print("User 1: ");
//                        String user1 = sc.nextLine();
//                        System.out.print("User 2: ");
//                        String user2 = sc.nextLine();
//                        DMService.viewMessages(user1, user2);
//                        break;
//
//                    case 10:
//                        // View notifications
//                        NotificationService.getNotifications(loggedInUser);
//                        break;
//
//                    case 11:
//                        // Add notification
//                        System.out.print("Enter notification message: ");
//                        String notificationMsg = sc.nextLine();
//                        NotificationService.addNotification(loggedInUser, notificationMsg);
//                        break;
//
//                    case 12:
//                        // Exit
//                        System.out.println("Exiting Post Management System...");
//                        sc.close();
//                        return;
//
//                    default:
//                        System.out.println("Invalid choice.");
//                }
//            }
//        }
//    }
//}
