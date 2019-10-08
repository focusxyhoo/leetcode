package practice.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/17
 * time        : 22:33
 * description :
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        Executor fixedPool = Executors.newFixedThreadPool(10);
        Executor siglePool = Executors.newSingleThreadExecutor();
        Executor cachedPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) {
//            fixedPool.execute(new Task());
            siglePool.execute(new Task());
        }
    }

    private static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
