package practice.threadpool;

import java.util.LinkedList;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/17
 * time        : 16:58
 * description :
 */
public class ThreadPool implements Pool {
    private boolean isShut;
    private LinkedList<Executor> pool;
    private int size;

    public ThreadPool(int size) {
        this.size = size;
        isShut = false;
        pool = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            ExecutorImpl executor = new ExecutorImpl();
            pool.add(executor);
            executor.start();
        }
    }

    @Override
    public Executor getExecutor() {
        Executor ret = null;
        synchronized (pool) {
            if (pool.size() > 0) {
                ret = pool.removeFirst();
            } else {
                try {
                    pool.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ret = pool.removeFirst();
            }
        }
        return ret;
    }

    @Override
    public void destroy() {
        synchronized (pool) {
            isShut = true;
            pool.notifyAll();
            pool.clear();
        }
    }

    private class ExecutorImpl extends Thread implements Executor {
        private Task task;
        private Object lock = new Object();
        public ExecutorImpl() {}

        @Override
        public void setTask(Task task) {
            this.task = task;
        }

        @Override
        public Task getTask() {
            return task;
        }

        @Override
        public void startTask() {
            synchronized (lock) {
                lock.notify();
            }
        }

        @Override
        public void run() {
            while (!isShut) {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                getTask().execute();
                synchronized (pool) {
                    pool.addFirst(ExecutorImpl.this);
                    pool.notifyAll();
                }
            }
        }
    }
}
