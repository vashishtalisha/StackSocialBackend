package NotificationsSystem;

import java.util.Scanner;

public class NotificationCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Notifications CLI ===");
            System.out.println("1. Add Notification");
            System.out.println("2. View Notifications");
            System.out.println("3. Mark All as Read");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Username: ");
                    String user = sc.nextLine();
                    System.out.print("Notification Message: ");
                    String msg = sc.nextLine();
                    NotificationService.addNotification(user, msg);
                    break;

                case 2:
                    System.out.print("Username: ");
                    String u = sc.nextLine();
                    NotificationService.getNotifications(u);
                    break;

                case 3:
                    System.out.print("Username: ");
                    String un = sc.nextLine();
                    NotificationService.markAllAsRead(un);
                    break;

                case 4:
                    System.out.println("Exiting Notification CLI...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
