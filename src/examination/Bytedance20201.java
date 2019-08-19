package examination;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-02
 * time        : 19:42
 * description :
 */
public class Bytedance20201 {

    private static int dele = 0;
    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int[] bytes = new int[26];
        int[] dances = new int[26];

        for (int i = 0; i < 26; i++) bytes[i] = Integer.parseInt(line[i]);
        line = scanner.nextLine().split(" ");
        for (int i = 0; i < 26; i++) dances[i] = Integer.parseInt(line[i]);

        int[] result = new int[52];
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                result[i] = bytes[i / 2];
            } else {
                result[i] = dances[i / 2];
            }
        }

        int byte_score = 0;
        int dance_score = 0;
//        int prev_num = 0;
        for (int i = 0; i < 52; i++) {
            int found = findPrev(result, i);
            dele += found;
            if (found != 0) {
                if (i % 2 == 0) {
                    if (flag) byte_score += (found - dele);
                } else {
                    dance_score += (found - dele);
                }
            }

        }

        if (byte_score > dance_score) System.out.println("Byte");
        else if (byte_score < dance_score) System.out.println("Dance");
        else System.out.println("Draw");

    }


    private static int findPrev(int[] nums, int index) {
        for (int i = 0; i < index; i++) {
            if (nums[i] == nums[index]) {
                for (int j = i; j <= index; j++) {
                    if (nums[j] != 0) {
                        nums[j] = 0;
                    } else {
                        flag = true;
                    }
                }
                dele += index - i + 1;
                return (index - i + 1);
            }
        }
        return 0;
    }
}
