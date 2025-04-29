package PostManagement;

import java.util.Scanner;

public class PostCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username;
        int choice;

        System.out.print("Enter your username: ");
        username = sc.nextLine();

        do {
            System.out.println("\n==== POST MANAGEMENT ====");
            System.out.println("1. Create Post");
            System.out.println("2. Edit Post");
            System.out.println("3. View My Posts");
            System.out.println("4. Like Post");
            System.out.println("5. Comment on Post");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter content: ");
                    String content = sc.nextLine();
                    CreatePost.create(username, content);
                }
                case 2 -> {
                    System.out.print("Enter Post ID to edit: ");
                    int postId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new content: ");
                    String newContent = sc.nextLine();
                    EditPost.edit(postId, newContent, username);
                }
                case 3 -> ViewOwnPosts.view(username);
                case 4 -> {
                    System.out.print("Enter Post ID to like: ");
                    int postId = sc.nextInt();
                    LikePost.like(postId, username);
                }
                case 5 -> {
                    System.out.print("Enter Post ID to comment on: ");
                    int postId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter comment: ");
                    String comment = sc.nextLine();
                    CommentPost.comment(postId, comment);
                }
                case 6 -> System.out.println("Exiting PostCLI...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
