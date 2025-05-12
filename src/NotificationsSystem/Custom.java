package NotificationsSystem;

public interface Custom<T> {
    void addFirst(T element);
    void addLast(T element);
    T removeFirst();
    T removeLast();
    T peekFirst();
    boolean isEmpty();
    int size();
}
