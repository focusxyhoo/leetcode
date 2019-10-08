package practice.threadpool;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/17
 * time        : 16:56
 * description :
 */
public interface Pool {
    Executor getExecutor();
    void destroy();
}
