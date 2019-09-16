package designpattern.singleton;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/10
 * time        : 22:55
 * description :
 */
public class EnumFactoryTest extends Thread {
    @Override
    public void run() {
        System.out.println(EnumFactory.singletonFactory.getInstance().hashCode());
    }

    public static void main(String[] args) {
        EnumFactoryTest[] testThreads = new EnumFactoryTest[10];
        for (int i = 0; i < testThreads.length; i++) {
            testThreads[i] = new EnumFactoryTest();
        }
        for (int i = 0; i < testThreads.length; i++) {
            testThreads[i].start();
        }
    }
}
