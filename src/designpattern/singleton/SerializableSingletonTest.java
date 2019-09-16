package designpattern.singleton;

import java.io.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/10
 * time        : 23:28
 * description :
 */
public class SerializableSingletonTest {
    public static void main(String[] args) {
        SerializableSingleton serializableSingleton = SerializableSingleton.getInstance();

        File serializableFile = new File("SerializableSingleton.txt");

        try {
            FileOutputStream fos = new FileOutputStream(serializableFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(serializableSingleton);
            fos.close();
            oos.close();
            System.out.println(serializableSingleton.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(serializableFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            SerializableSingleton singletonFromFile = (SerializableSingleton) ois.readObject();
            fis.close();
            ois.close();
            System.out.println(singletonFromFile.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
