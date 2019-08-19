package hard;

import java.util.Arrays;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-12
 * time        : 15:23
 * description : 给出一个未排序的数组，找出其中缺失的最小正整数。
 */
public class T41_FirstMissingPositive {

    /**
     * 先对数组进行排序，然后遍历一遍数组，进行比较即可。
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int comp = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == comp) {
                comp++;
            }
        }
        return comp;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
    }
}
