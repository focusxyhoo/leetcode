package easy;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-21
 * time        : 10:23
 * description : 从有序数组中删除重复的元素，并返回没有重复元素的数组大小。
 */
public class T26_RemoveDuplicatesFromSotedArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 4, 4, 5};
        System.out.println(removeDuplicates(nums));
        for (int x : nums) {
            System.out.print(x + ", ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
