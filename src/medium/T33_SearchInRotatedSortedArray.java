package medium;

/**
 * @author focusxyhoo
 * @date 2019-05-05 20:48
 */
public class T33_SearchInRotatedSortedArray {
    /**
     * 题目的意思是：将一个升序排序的数组从某处打断，然后再连接起来。
     * 要求给定一个数，查找数组中是否存在该树，存在则返回其下标，否则返回-1。
     * 数组中不存在重复的数。
     * 且要求时间复杂度在O(logn)。
     * 写得太乱，思路不清晰。建议多参考其他人的写法。
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int len = nums.length;
        int low = 0, high = len - 1;
        if (target < nums[low]) {
            while (high > 0 && nums[high - 1] < nums[high]) {
                if (nums[high] == target)
                    return high;
                high--;
            }
            if (nums[high] == target) return high;
            return -1;
        } else {
            while (low < len - 1 && nums[low + 1] > nums[low]) {
                if (nums[low] == target)
                    return low;
                low++;
            }
            if (nums[low] == target) return low;
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 7;
        System.out.println(search(nums, target));
    }
}
