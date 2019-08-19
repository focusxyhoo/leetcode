package medium;

/**
 * @author focusxyhoo
 * @date 2019-05-06 11:46
 */
public class T34_FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 题目不是很难，可以独立调试通过。
     * 当时需要考虑下调整自己的思路以及代码的写法。
     * 参考 https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/
     * @param nums
     * @param target
     * @return
     */
    // 线性遍历
    public static int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (flag == 0) {
                    first = i;
                    last = i;
                    flag = 1;
                } else {
                    last = i;
                }
            }
        }
        return new int[]{first, last};
    }

    // 二分查找
    public static int[] searchRange2(int[] nums, int target) {
        int first = -1;
        int last = -1;
        if (nums.length == 0) {
            return new int[]{first, last};
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                int tempf = mid;
                first = mid;
                while (tempf - 1 >= low && nums[tempf - 1] == target) {
                    first = tempf - 1;
                    tempf--;
                }
                int templ = mid;
                last = mid;
                while (templ + 1 <= high && nums[templ + 1] == target) {
                    last = templ + 1;
                    templ++;
                }
                return new int[]{first, last};
            }
        }
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 7, 8, 8, 10};
        int[] result = searchRange2(nums, 7);
        for (int x : result) {
            System.out.println(x);
        }
    }
}
