package DirectMessages;

import java.util.Scanner;

public class DMCLI {


    public static void main(String[] args) {
//        DMDataStorage.loadAllChats();
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Direct Messages CLI ===");

        while (true) {
            System.out.println("\n1. Send Message");
            System.out.println("2. View Conversation");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Sender: ");
                    String sender = sc.nextLine();
                    System.out.print("Receiver: ");
                    String receiver = sc.nextLine();
                    System.out.print("Message: ");
                    String content = sc.nextLine();
                    DMService.sendMessage(sender, receiver, content);
                    break;

                case 2:
                    System.out.print("User 1: ");
                    String u1 = sc.nextLine();
                    System.out.print("User 2: ");
                    String u2 = sc.nextLine();
                    DMService.viewMessages(u1, u2);
                    break;

                case 3:
                    System.out.println("Exiting DMs CLI...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
//        DMDataStorage.saveAllChats();

    }
}
