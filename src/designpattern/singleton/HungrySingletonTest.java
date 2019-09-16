package designpattern.singleton;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/10
 * time        : 23:11
 * description :
 */
public class HungrySingletonTest extends Thread{
    @Override
    public void run() {
        System.out.println(HungrySingleton.getInstance().hashCode());
    }

    public static void main(String[] args) {
        HungrySingletonTest[] testThreads = new HungrySingletonTest[10];
        for (int i = 0; i < testThreads.length; i++) {
            testThreads[i] = new HungrySingletonTest();
            testThreads[i].start();
        }

    }
}
