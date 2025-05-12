package NotificationsSystem;

public class CustomDeque<T> implements Custom<T> {
    private Object[] elements;
    private int size;
    private int front;
    private int rear;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomDeque() {
        elements = new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void addFirst(T element) {
        if (size == elements.length) {
            resize();
        }
        front = (front - 1 + elements.length) % elements.length;
        elements[front] = element;
        size++;
    }

    @Override
    public void addLast(T element) {
        if (size == elements.length) {
            resize();
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = element;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T element = (T) elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return element;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T element = (T) elements[rear];
        elements[rear] = null;
        rear = (rear - 1 + elements.length) % elements.length;
        size--;
        return element;
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return (T) elements[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(front + i) % elements.length];
        }
        elements = newElements;
        front = 0;
        rear = size - 1;
    }
}
