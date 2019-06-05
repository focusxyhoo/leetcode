import java.util.HashMap;
import java.util.Map;

public class Test {
    private static final Map<String, String> myMap = new HashMap<>();

    static {
        myMap.put("2", "abc");
        myMap.put("3", "efg");
    }

    public static int x = 5;

    public Test() {
    }

    public static void increment() {
        x = x + 1;
    }

    public static void main(String[] args) {
        System.out.println(myMap.isEmpty());
        Test t = new Test();

        System.out.println(x);
        increment();
        System.out.println(x);

//        System.out.println(map.get("2"));
        StringBuffer myString = new StringBuffer("hello, world!");
        System.out.println(myString.length());
        myString.append("this is my world.");
        System.out.println(myString.length());
    }
}
