package practice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/25
 * time        : 17:39
 * description :
 */
public class ManagerInvocationHandler implements InvocationHandler {
    Object agent;

    public ManagerInvocationHandler(Object agent) {
        this.agent = agent;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("sell")) {
            System.out.println("### manager : before sell : register ###");
            method.invoke(agent, args);
            System.out.println("### manager : after sell : publish ###");
        } else method.invoke(agent, args);
        return null;
    }
}
