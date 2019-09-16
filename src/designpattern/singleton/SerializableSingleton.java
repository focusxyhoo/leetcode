package designpattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/10
 * time        : 23:03
 * description :
 */
public class SerializableSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private static class SingletonHandler {
        private static SerializableSingleton INSTANCE = new SerializableSingleton();
    }

    private SerializableSingleton() {}
    public static SerializableSingleton getInstance() {
        return SingletonHandler.INSTANCE;
    }

    protected Object readResolve() throws ObjectStreamException {
        return SingletonHandler.INSTANCE;
    }
}
