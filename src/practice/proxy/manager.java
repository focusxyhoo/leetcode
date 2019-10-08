package practice.proxy;

import javax.management.InstanceNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/25
 * time        : 17:27
 * description :
 */
public class Manager {

    // 静态代理
    public static void moniterSell() {
        ProxyWalmart walmart = new ProxyWalmart();
        walmart.sell();
    }

    public static void monitorProxySell() {
        Supermarket walmart = new Walmart();
        Supermarket carrefour = new Carrefour();

        Class proxySupermarket = Proxy.getProxyClass(walmart.getClass().getClassLoader(), walmart.getClass().getSuperclass().getInterfaces());
        try {
            System.out.println("### without dynamic proxy pattern ###");
            walmart.sell();
            carrefour.sell();

            System.out.println("### proxy 1 : dynamic proxy pattern on  ###");
            System.out.println("proxy class is : " + proxySupermarket.getName());

            Constructor constructor = proxySupermarket.getConstructor(new Class[]{InvocationHandler.class});

            ManagerInvocationHandler walmartHandler = new ManagerInvocationHandler(walmart);
            ManagerInvocationHandler carrefourHandler = new ManagerInvocationHandler(carrefour);

            Supermarket proxyWalmart = (Supermarket) constructor.newInstance(new Object[]{walmartHandler});
            Supermarket proxyCarrefour = (Supermarket) constructor.newInstance(new Object[]{carrefourHandler});

            proxyWalmart.sell();
            proxyCarrefour.sell();
            System.out.println("### proxy 1 end ###");

            System.out.println("### proxy 2 : dynamic proxy pattern on Proxy.newProxyInstance() method ###");

            Supermarket proxyObject2 = (Supermarket) Proxy.newProxyInstance(Supermarket.class.getClassLoader(), new Class[]{Supermarket.class}, walmartHandler);
            proxyObject2.sell();
            proxyObject2.buy();
            System.out.println("### proxy 2 end ###");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        moniterSell();
        monitorProxySell();
    }
}
