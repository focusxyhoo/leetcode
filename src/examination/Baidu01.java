package examination;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/10
 * time        : 19:22
 * description :
 */
public class Baidu01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            int num = scanner.nextInt();
            map.put(value, num);
        }
        System.out.println(getMonthes(map, m));
    }

    private static int getMonthes(TreeMap<Integer, Integer> map, int m) {
        int count = 0;
        Set<Integer> orderingSet = map.descendingKeySet();
        Iterator<Integer> it = orderingSet.iterator();
        int[] keys = new int[map.size()];
        int index = 0;
        while (it.hasNext()) {
            keys[index] = it.next();
            index++;
        }
        for (int i = 0; i < keys.length; i++) {
            if (map.get(keys[i]) > 0) {
                if (keys[i] >= m) count += map.get(keys[i]);
                else {
                    for (int j = keys.length - 1; j > i; j--) {
                        if (map.get(keys[i]) == 0) break;
                        if (keys[i] + keys[j] >= m) {
                            int min = Math.min(map.get(keys[i]), map.get(keys[j]));
                            count += min;
                            if (map.get(keys[i]) > min) {
                                map.put(keys[i], map.get(keys[i]) - min);
                            } else map.put(keys[i], 0);
                            if (map.get(keys[j]) > min) {
                                map.put(keys[j], map.get(keys[j]) - min);
                            } else map.put(keys[j], 0);
                        }
                    }
                    if (map.get(keys[i]) > 0) count += (map.get(keys[i]) / 2);
                }
            }
        }
        return count;
    }
}
