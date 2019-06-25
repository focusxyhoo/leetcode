package medium;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-06-23
 * time        : 21:27
 * description :
 */
public class T50_Pow {

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 100));
        System.out.println(Math.pow(2.0, 0.0));
    }

    // brute force
    // time limit exceeded
    public static double myPow(double x, int n) {
        double sum = 1.0;
        boolean flag = true;
        if (n == 0) return 1.0;
        if (n < 0) flag = false;
        n = Math.abs(n);
        for (int i = 1; i <= n; i++) {
            sum *= x;
        }
        if (!flag) return 1/sum;
        return sum;
    }

    public static double myPow2(double x, int n) {

        if (n == 0) return 1.0;


        return 0.0;
    }
}
