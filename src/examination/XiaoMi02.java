//package examination;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
///**
// * created with IntelliJ IDEA
// * author      : focusxyhoo
// * date        : 2019/9/11
// * time        : 20:08
// * description :
// */
//public class XiaoMi02 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = scanner.nextInt();
//        }
//        int increasingCount = 0;
//        for (int i = 1; i < n; i++) {
//            int j = i - 1
//            while (j >= 0) {
//                if (nums[j] < nums[i]) {
//                    j--;
//                    continue;
//                } if (nums[j] == nums[i]) {
//                    break;
//                } else {
//
//                }
//
//            }
//            if (nums[i] < nums[i - 1]) {
//                swap(nums, i, i - 1);
//                increasingCount++;
//            }
//        }
//
//        int decreasingCount = 0;
//        for (int i = 1; i < n; i++) {
//            if (nums[i])
//        }
//    }
//    private static void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//
//    }
//}
//
//
