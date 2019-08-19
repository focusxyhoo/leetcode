package hard;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-21
 * time        : 13:59
 * description :
 */
public class T786_KthSmallestPrimeFraction {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        for (int x : kthSmallestPrimeFraction(nums, 3)) {
            System.out.print(x + ", ");
        }
    }

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] kthSmallestPrimeFraction(int[] nums, int k) {
        final int n = nums.length;
        double left = 0, right = 1.0;
        while (left < right) {
            double midlle = (left + right) / 2;
            double max_f = 0.0;
            int total = 0;
            int p = 0;
            int q = 0;
            for (int i = 0, j = 1; i < n - 1; ++i) {
                while (j < n && nums[i] > midlle * nums[j]) ++j;
                if (n == j) break;
                total += (n - j);
                final double f = (double) nums[i] / nums[j];
                if (f > max_f) {
                    p = i;
                    q = j;
                    max_f = f;
                }
            }
            if (total == k) return new int[]{nums[p], nums[q]};
            else if (total > k) right = midlle;
            else left = midlle;
        }
        return new int[]{};
    }
}
