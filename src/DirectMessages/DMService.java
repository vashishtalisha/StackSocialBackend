package DirectMessages;

import java.util.*;

public class DMService {
    private static Map<String, Map<String, ChatHistory>> chats = new HashMap<>();

    public static void sendMessage(String sender, String receiver, String content) {
        chats.putIfAbsent(sender, new HashMap<>());
        chats.putIfAbsent(receiver, new HashMap<>());

        chats.get(sender).putIfAbsent(receiver, new ChatHistory());
        chats.get(receiver).putIfAbsent(sender, new ChatHistory());

        Message message = new Message(sender, receiver, content);
        chats.get(sender).get(receiver).addMessage(message);
        chats.get(receiver).get(sender).addMessage(message);
    }

    public static void viewMessages(String user1, String user2) {
        if (chats.containsKey(user1) && chats.get(user1).containsKey(user2)) {
            System.out.println("Conversation between " + user1 + " and " + user2 + ":");
            chats.get(user1).get(user2).printMessages();
        } else {
            System.out.println("No messages between " + user1 + " and " + user2);
        }
    }
}
