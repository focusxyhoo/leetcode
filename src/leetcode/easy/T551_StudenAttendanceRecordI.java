package easy;

import java.util.regex.Pattern;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-25
 * time        : 17:33
 * description :
 */
public class T551_StudenAttendanceRecordI {

    public static boolean checkRecord(String s) {

        int absent = 0, late = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'A') absent++;
            if (s.charAt(i) == 'L') late++; // 注意这两个 if 是独立的。
            else late = 0;
            if (absent > 1 || late > 2) return false;
        }
        return true;
    }

    // 搞不清楚 Java 里的正则表达式。
    public static boolean checkRecordRex(String s) {
        return !Pattern.matches("A.*A|LLL", s);
    }

    public static void main(String[] args) {

        System.out.println(checkRecordRex("LALA"));
    }
}
