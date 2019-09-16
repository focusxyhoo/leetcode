package designpattern.singleton;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/10
 * time        : 22:57
 * description :
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {}
    public static HungrySingleton getInstance() {
        return instance;
    }
}
