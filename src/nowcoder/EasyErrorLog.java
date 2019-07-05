package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-04
 * time        : 11:51
 * description :
 */
public class EasyErrorLog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Log> list = new ArrayList<>();

        while (scanner.hasNext()) {
            String[] tokens = scanner.nextLine().split(" ");
            String path = tokens[0];
            String name = path.substring(path.lastIndexOf("\\") + 1);
            int number = Integer.parseInt(tokens[1]);
            name = rename(name);

            Log log = new Log(name, number);
            if (list.contains(log)) {
                int index = list.indexOf(log);
                Log temp = list.get(index);
                temp.count++;
            } else list.add(log);
        }

        if (list.size() >= 8) {
            for (int i = list.size() - 8; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } else {
            for (Log item : list) System.out.println(item);
        }

    }

    private static String rename(String s) {
        if (s.length() > 16) {
            s = s.substring(s.length() - 16);
        }
        return s;
    }
}

class Log {
    String name;
    int number;
    int count;

    public Log(String name, int number) {
        this.name = name;
        this.number = number;
        this.count = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return number == log.number &&
                Objects.equals(name, log.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return name + " " + number + " " + count;
    }
}
