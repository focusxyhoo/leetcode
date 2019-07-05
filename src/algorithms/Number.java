package algorithms;
import java.util.*;
public class Number {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split(" ");
            int key = Integer.parseInt(line[0]);
            int value = Integer.parseInt(line[1]);
            if (map.containsKey(key)) {
                int temp = map.get(key);
                temp += value;
                map.put(key, temp);
            } else {
                map.put(key, value);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        for (Map.Entry<Integer, Integer> item : list) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}