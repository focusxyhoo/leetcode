package structure;


/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-18
 * time        : 13:28
 * description :
 */
public class QueueList implements Queue{
    private ListNode head;
    private ListNode tail;
    private int n;

    public QueueList() {
        this.head = null;
        this.tail = null;
        this.n = 0;
    }

    @Override
    public boolean put(Object o) {
        return false;
    }

    @Override
    public Object pull() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        return n;
    }
}
