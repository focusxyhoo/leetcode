import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("!");
        list.remove(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " : " + i);
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.
        if (map.containsKey('a')) System.out.println(map.get('a'));
    }
}