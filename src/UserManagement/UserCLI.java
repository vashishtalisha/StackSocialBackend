package UserManagement;

import java.util.Scanner;
import java.util.List;

public class UserCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currentUser = null;

        while (true) {
            System.out.println("\n=== StackSocial CLI Menu ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Profile");
            System.out.println("4. Search User by Name");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String regUser = sc.nextLine();
                    System.out.print("Enter password: ");
                    String regPass = sc.nextLine();
                    RegisterUser.register(regUser, regPass);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String loginUser = sc.nextLine();
                    System.out.print("Enter password: ");
                    String loginPass = sc.nextLine();
                    if (LoginUser.login(loginUser, loginPass)) {
                        currentUser = loginUser;
                    }
                    break;

                case 3:
                    if (currentUser != null) {
                        ViewProfile.view(currentUser);
                    } else {
                        System.out.println("You must login first.");
                    }
                    break;

                case 4:
                    System.out.print("Enter search keyword: ");
                    String keyword = sc.nextLine();
                    List<String> results = SearchByName.search(keyword);
                    if (results.isEmpty()) {
                        System.out.println("No users found.");
                    } else {
                        System.out.println("Matching users:");
                        for (String name : results) {
                            System.out.println("- " + name);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
