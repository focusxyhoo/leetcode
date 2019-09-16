//package examination;
//
//import java.util.Scanner;
//
///**
// * created with IntelliJ IDEA
// * author      : focusxyhoo
// * date        : 2019/9/12
// * time        : 16:20
// * description :
// */
//public class Qunar01 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[][] nums = new int[][];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                nums[i][j] = scanner.nextInt();
//            }
//        }
//        int maxSum = Integer.MIN_VALUE;
//        int[][] dp = new int[n][n];
//
//
//        for (int i = 0; i < n * n; i += n) {
//            int tempSum = 0;
//            for (int j = i; j < n; j++) {
//                tempSum += nums[j];
//            }
//            maxSum = Math.max(maxSum, tempSum);
//        }
//
//        for (int i = 0; i < n; i++) {
//            int tempSum = 0;
//            for (int j = i; j < n * n; j += n) {
//                tempSum += nums[j];
//            }
//            maxSum = Math.max(maxSum, tempSum);
//        }
//        System.out.println(maxSum);
//    }
//}
