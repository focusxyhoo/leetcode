package structure;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-18
 * time        : 12:30
 * description :
 */
public class CircularQueueArray implements Queue{
    private final Object[] queue;
    private int head;
    private int tail;

    public CircularQueueArray(int capacity) {
        this.queue = new Object[capacity + 1];
    }

    public boolean put(Object o) {
        if (isFull()) return false;
        queue[tail] = o;
        tail = (tail + 1) % queue.length;
        return true;
    }

    public Object peek() {
        if (isEmpty()) return null;
        return queue[head];
    }

    public Object pull() {
        if (isEmpty()) return null;
        Object item = queue[head];
        queue[head] = null;
        return item;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return head == (tail + 1) % queue.length;
    }

    public int size() {
        if (tail >= head) return tail - head;
        else return (tail + queue.length) - head;
    }
}
