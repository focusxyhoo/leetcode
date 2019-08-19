package examination;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-02
 * time        : 17:30
 * description :
 */
public class Bytedance2019B {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = Integer.parseInt(in.nextLine());
        List<Interval> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] line = in.nextLine().split(";");
            for (String item : line) {
                String[] time = item.split(",");
                list.add(new Interval(Integer.parseInt(time[0]), Integer.parseInt(time[0])));
            }
        }
        in.close();

        // 自定义排序
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
//        Collections.sort(list, (Interval o1, Interval o2) -> o1.start - o2.start);

        Interval prev = null;
        List<Interval> result = new ArrayList<>();

        for (Interval item : list) {
            if (prev == null || item.start >= prev.end) {
                result.add(item);
                prev = item;
            } else if (item.end >= prev.end) {
                prev.end = item.end;
            }
        }

        // 打印结果
        int count = 0;
        for (Interval item : result) {
            if (count == result.size() - 1) {
                System.out.print(item.start + "," + item.end);
            } else {
                System.out.print(item.start + "," + item.end + ";");
            }
            count++;
        }
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
