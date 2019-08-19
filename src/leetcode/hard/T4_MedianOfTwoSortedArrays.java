package leetcode.hard;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-10
 * time        : 16:05
 * description : 两个有序数组的中位数。
 */
public class T4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
//        System.out.println(3 / 2.0);
//        System.out.println(3 / 2);
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays2(nums1, nums2));

        int[] nums3 = {1, 3};
        int[] nums4 = {2};
        System.out.println(findMedianSortedArrays2(nums3, nums4));
    }

    /**
     * written by focusxyhoo:
     * ✔ Accepted
     * ✔ 2084/2084 cases passed (3 ms)
     * ✔ Your runtime beats 56.62 % of java submissions
     * ✔ Your memory usage beats 90.96 % of java submissions (47.1 MB)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                result[k] = nums1[i];
                k++;
                i++;
            } else {
                result[k] = nums2[j];
                k++;
                j++;
            }
        }
        if (i < n) {
            while (i < n) {
                result[k++] = nums1[i++];
            }
        }
        if (j < m) {
            while (j < m) {
                result[k++] = nums2[j++];
            }
        }
        if (result.length % 2 != 0) {
            return result[result.length / 2];
        } else {
            int middle = result.length / 2;
            return (result[middle] + result[middle - 1]) / 2.0;
        }
    }

    /**
     * created by Pioneer4:
     * Java Solution:(2ms)faster than 100.00%, (48.3)less than 86.61%.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int index1 = 0, index2 = 0; // 分别对应两个数组的下标
        int med1 = 0, med2 = 0; // 记录中间的值
        // 只遍历到两个数组长度之和的中间位置
        for (int i = 0; i <= (nums1.length + nums2.length) / 2; i++) {
            med1 = med2;
            if (index1 == nums1.length) {
                med2 = nums2[index2];
                index2++;
            } else if (index2 == nums2.length) {
                med2 = nums1[index1];
                index1++;
            } else if (nums1[index1] < nums2[index2]) {
                med2 = nums1[index1];
                index1++;
            } else {
                med2 = nums2[index2];
                index2++;
            }
        }

        // the median is the average of two numbers
        // 也可以用位运算来判断一个树是否是偶数
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (float) (med1 + med2) / 2;
        }

        return med2;
    }
}
