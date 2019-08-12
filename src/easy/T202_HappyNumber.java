package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-12
 * time        : 08:31
 * description : https://leetcode.com/problems/happy-number/
 */
public class T202_HappyNumber {
    public static void main(String[] args) {
        System.out.println(split(122));
    }

    public static boolean isHappy(int n) {
        List<Integer> nums;
        HashSet<Integer> set = new HashSet<>();
        while (n > 1) {
            if (set.contains(n)) return false;
            else set.add(n);
            nums = split(n);
            n = combine(nums);
        }
        return n == 1;
    }

    private static List<Integer> split(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        return list;
    }

    private static int combine(List<Integer> nums) {
        int result = 0;
        for (int i : nums) {
            result += i * i;
        }
        return result;
    }
}
