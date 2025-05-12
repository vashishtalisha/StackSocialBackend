package NotificationsSystem;

import java.util.Map;
import java.util.HashMap;

public class NotificationService {
    private static Map<String, CustomDeque<Notification>> notifications = new HashMap<>();

    public static void addNotification(String username, String message) {
        notifications.putIfAbsent(username, new CustomDeque<>());
        notifications.get(username).addFirst(new Notification(message));
    }

    public static void getNotifications(String username) {
        System.out.println("\n--- Notifications for " + username + " ---");
        CustomDeque<Notification> deque = notifications.getOrDefault(username, new CustomDeque<>());

        if (deque.isEmpty()) {
            System.out.println("No notifications.");
        } else {
            for (int i = 0; i < deque.size(); i++) {
                Notification n = deque.removeFirst(); // Get the first notification and remove it temporarily
                System.out.println(n.getMessage());
                deque.addLast(n); // Re-add it to the deque to maintain its state
            }
        }
    }

    public static void markAllAsRead(String username) {
        CustomDeque<Notification> deque = notifications.getOrDefault(username, new CustomDeque<>());
        for (int i = 0; i < deque.size(); i++) {
            Notification n = deque.removeFirst(); // Get notification
            n.markAsRead();
            deque.addLast(n); // Re-add after marking as read
        }
        System.out.println("All notifications marked as read for " + username);
    }
}
