package practice.threadpool;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/17
 * time        : 16:57
 * description :
 */
public interface Executor {
    void setTask(Task task);
    Task getTask();
    void startTask();
}
