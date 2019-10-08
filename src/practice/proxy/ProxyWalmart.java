package practice.proxy;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/25
 * time        : 17:28
 * description :
 */
public class ProxyWalmart extends Walmart{
    ProxyWalmart() {
        super();
    }

    @Override
    public void sell() {
        System.out.println("monitoring supermarket: " + this.name + " selling.");
    }
}
