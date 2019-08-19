package algorithms;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-16
 * time        : 12:44
 * description :
 */
public class PriorityQueue {
    int[] pq;
    int CAPACITY = 1000;
    int size;

    public PriorityQueue(int capacity) {
        this.pq = new int[capacity + 1];
        this.size = 0;
    }

    public PriorityQueue() {
        this.pq = new int[CAPACITY + 1];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int top() {
        assert !isEmpty();
        return pq[1];
    }

//    public void add(int n); // insert element into PQ
//    public int poll(); // get and remove top element

    private void siftUp() {
        int i = size; // size has been updated and now represents the newly added element
        for (; i > 1 && pq[i / 2] < pq[i]; i /= 2) {
            swap(pq, i / 2, i);
        }
    }

    private void siftDown() {

    }

    private void swap(int[] pq, int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
