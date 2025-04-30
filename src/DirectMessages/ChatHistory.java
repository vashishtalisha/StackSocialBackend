package DirectMessages;

public class ChatHistory {
    private Message head, tail;

    public void addMessage(Message message) {
        if (head == null) {
            head = tail = message;
        } else {
            tail.next = message;
            message.prev = tail;
            tail = message;
        }
    }

    public void printMessages() {
        Message current = head;
        while (current != null) {
            System.out.println(current.getFormatted());
            current = current.next;
        }
    }
}
