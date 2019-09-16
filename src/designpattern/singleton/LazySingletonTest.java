package designpattern.singleton;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/10
 * time        : 23:22
 * description :
 */
public class LazySingletonTest extends Thread{
    @Override
    public synchronized void start() {
        System.out.println(LazySingleton.getInstance().hashCode());
    }

    public static void main(String[] args) {
        LazySingletonTest[] testThreads = new LazySingletonTest[10];
        for (int i = 0; i < testThreads.length; i++) {
            testThreads[i] = new LazySingletonTest();
            testThreads[i].start();
        }
    }
}
