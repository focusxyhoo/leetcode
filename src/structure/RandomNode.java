package structure;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-11
 * time        : 13:42
 * description : 链表节点。其中，节点中除了有指向下一个节点的 next 字段外，还有一个指向随机节点的 random 字段。
 */
public class RandomNode {
    public int val;
    public RandomNode next;
    public RandomNode random;

    public RandomNode() {}

    public RandomNode(int val) {
        this.val = val;
    }
}
