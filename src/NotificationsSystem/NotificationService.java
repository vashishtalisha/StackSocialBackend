package NotificationsSystem;

import java.util.*;

public class NotificationService {
    private static Map<String, Deque<Notification>> notifications = new HashMap<>();

    public static void addNotification(String username, String message) {
        notifications.putIfAbsent(username, new LinkedList<>());
        notifications.get(username).addFirst(new Notification(message));
    }

    public static void getNotifications(String username) {
        System.out.println("\n--- Notifications for " + username + " ---");
        Deque<Notification> queue = notifications.getOrDefault(username, new LinkedList<>());

        if (queue.isEmpty()) {
            System.out.println("No notifications.");
        } else {
            for (Notification n : queue) {
                System.out.println(n.getMessage());
            }
        }
    }

    public static void markAllAsRead(String username) {
        Deque<Notification> queue = notifications.getOrDefault(username, new LinkedList<>());
        for (Notification n : queue) {
            n.markAsRead();
        }
        System.out.println("All notifications marked as read for " + username);
    }
}
