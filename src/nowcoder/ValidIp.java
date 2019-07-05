package nowcoder;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-04
 * time        : 10:07
 * description :
 */
public class ValidIp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int typeA = 0, typeB = 0, typeC = 0, typeD = 0, typeE = 0, error = 0, privateIp = 0;

        while (in.hasNext()) {
            String[] ipAndMask = in.nextLine().split("~");
            String ip = ipAndMask[0];
            String mask = ipAndMask[1];

            if (!isValidFormat(ip) || !isValidFormat(mask)) {
                error++;
                continue;
            }

            if (!checkMask(mask)) {
                error++;
                continue;
            }

            String[] tokens = ip.split("\\.");
            int first = Integer.parseInt(tokens[0]);
            int second = Integer.parseInt(tokens[1]);

            if (first >= 1 && first <= 126) typeA++;
            else if (first >= 128 && first <= 191) typeB++;
            else if (first >= 192 && first <= 223) typeC++;
            else if (first >= 224 && first <= 239) typeD++;
            else if (first >= 240 && first <= 255) typeE++;

            if (first == 10 || (first == 127 && second >= 16 && second <= 31) || (first == 192 && second == 168))
                privateIp++;
        }

        in.close();
        System.out.println(typeA + " " + typeB + " " + typeC + " " + typeD + " " + typeE + " " + error + " " + privateIp);
    }

    private static boolean isValidFormat(String s) {
        boolean result = true;
        if (s == null || s.length() == 0) return false;
        Pattern pattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");
        Matcher matcher = pattern.matcher(s);

        if (matcher.matches()) {
            String[] nums = s.split("\\.");
            for (String num : nums) {
                int n = Integer.parseInt(num);
                if (n < 0 || n > 255) {
                    result = false;
                    break;
                }
            }
        } else result = false;
        return result;
    }

    /**
     * 将一个整型数字转变为二进制字符串。
     *
     * @param num
     * @return
     */
    private static String toBinary(int num) {
        StringBuilder sb = new StringBuilder();
        int flag = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int val = (flag & num) == 0 ? 0 : 1;
            sb.append(val);
            num <<= 1;
        }
        return sb.toString();
    }

    private static boolean checkMask(String s) {
        boolean result = true;
        StringBuilder sb = new StringBuilder();
        String[] nums = s.split("\\.");
        for (String item : nums) {
            int n = Integer.parseInt(item);
            sb.append(toBinary(n));
        }
        int first0Index = sb.indexOf("0");
        int last1Index = sb.lastIndexOf("1");
        if (first0Index < last1Index) result = false;
        return result;
    }
}
