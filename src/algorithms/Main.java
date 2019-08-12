package algorithms;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-12
 * time        : 21:27
 * description :
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double d = in.nextDouble();

        DecimalFormat df = new DecimalFormat(".00");
        System.out.println(df.format(d));

    }
}
