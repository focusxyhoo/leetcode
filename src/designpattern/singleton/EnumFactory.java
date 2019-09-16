package designpattern.singleton;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/10
 * time        : 22:52
 * description :
 */
public enum EnumFactory {
    singletonFactory;
    private Singleton instance;
    private EnumFactory() {
        this.instance = new Singleton();
    }
    public Singleton getInstance() {
        return instance;
    }
}

class Singleton {
    public Singleton(){}
}
