package structure;


/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-18
 * time        : 12:54
 * description :
 */
public class CircularQueueArrayTest {
    public static void main(String[] args) {
        CircularQueueArray queue = new CircularQueueArray(3);
        System.out.println(queue.isEmpty());
        System.out.println(queue.put("hello"));
        System.out.println(queue.put("world"));
        System.out.println(queue.put("this"));
        System.out.println(queue.isFull());
        System.out.println(queue.size());
        System.out.println(queue.put("is"));

    }
}