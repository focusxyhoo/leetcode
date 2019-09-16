package designpattern.singleton;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/10
 * time        : 23:23
 * description :
 */
public class StaticInnerClassSingletonTest extends Thread {

    @Override
    public void run() {
        System.out.println(StaticInnerClassSingleton.getInstance().hashCode());
    }

    public static void main(String[] args) {
        StaticInnerClassSingletonTest[] testThreads = new StaticInnerClassSingletonTest[10];
        for (int i = 0; i < testThreads.length; i++) {
            testThreads[i] = new StaticInnerClassSingletonTest();
            testThreads[i].start();
        }
    }
}
