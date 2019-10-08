import java.util.*;

public class Test {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        try {
            i++;
            System.out.println("1:" + i);
        } catch (Exception e){
            i++;
            System.out.println("2:" + i);
        } finally {
            i++;
            System.out.println("3:" + i);
        }
    }
}