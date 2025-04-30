package FollowersSystem;

import java.util.*;

public class FollowersCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Followers System CLI ===");

        while (true) {
            System.out.println("\n1. Follow User");
            System.out.println("2. Unfollow User");
            System.out.println("3. View Followers");
            System.out.println("4. Get Follow Suggestions");
            System.out.println("5. View All Follow Data");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            String currentUser, targetUser;

            switch (choice) {
                case 1:
                    System.out.print("Enter your username: ");
                    currentUser = sc.nextLine();
                    System.out.print("Enter username to follow: ");
                    targetUser = sc.nextLine();
                    FollowUser.follow(currentUser, targetUser);
                    break;

                case 2:
                    System.out.print("Enter your username: ");
                    currentUser = sc.nextLine();
                    System.out.print("Enter username to unfollow: ");
                    targetUser = sc.nextLine();
                    UnfollowUser.unfollow(currentUser, targetUser);
                    break;

                case 3:
                    System.out.print("Enter username to view followers: ");
                    targetUser = sc.nextLine();
                    GetFollowers.printFollowers(targetUser);
                    break;

                case 4:
                    System.out.print("Enter your username: ");
                    currentUser = sc.nextLine();
                    FollowSuggestions.printSuggestions(currentUser);
                    break;

                case 5:
                    System.out.println("\n--- Full Follow Graph ---");
                    for (Map.Entry<String, Set<String>> entry : FollowGraph.graph.entrySet()) {
                        System.out.println(entry.getKey() + " follows: " + entry.getValue());
                    }
                    break;

                case 6:
                    System.out.println("Exiting CLI...");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
