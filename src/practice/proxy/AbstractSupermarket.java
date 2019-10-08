package practice.proxy;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/25
 * time        : 17:22
 * description :
 */
public class AbstractSupermarket implements Supermarket {
    public String name;

    AbstractSupermarket(String name) {
        this.name = name;
    }

    @Override
    public void buy() {
        System.out.println("supermarket: " + name + " : buying somethings.");
    }

    @Override
    public void sell() {
        System.out.println("supermarket: " + name + " : selling somethings.");
    }
}
