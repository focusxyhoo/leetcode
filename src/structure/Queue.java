package structure;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-18
 * time        : 13:31
 * description :
 */
public interface Queue {
    public boolean put(Object o);
    public Object pull();
    public Object peek();
    public boolean isEmpty();
    public int size();
    public String toString();
}
