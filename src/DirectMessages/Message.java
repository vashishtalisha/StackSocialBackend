package DirectMessages;

import java.time.LocalDateTime;

public class Message {
    private String sender;
    private String receiver;
    private String content;
    private LocalDateTime timestamp;
    Message prev, next;  // for doubly linked list

    public Message(String sender, String receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.prev = null;
        this.next = null;
    }

    public String getFormatted() {
        return "[" + timestamp + "] " + sender + " to " + receiver + ": " + content;
    }
}
