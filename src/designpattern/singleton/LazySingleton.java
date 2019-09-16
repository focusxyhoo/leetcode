package designpattern.singleton;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/10
 * time        : 22:59
 * description :
 */
public class LazySingleton {
    private volatile static LazySingleton instance = null;
    private LazySingleton() {}
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
