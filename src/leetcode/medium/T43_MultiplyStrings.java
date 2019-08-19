package medium;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-23
 * time        : 18:26
 * description :
 */
public class T43_MultiplyStrings {
    public static void main(String[] args) {

        String s1 = "1235678";
        String s2 = "4567899";
        System.out.println(multipy(s1, s2));

    }

    public static String multipy(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int pos1 = i+j; // 在前
                int pos2 = i+j+1; // 在后

                temp += result[pos2];
                result[pos2] = temp % 10;
                result[pos1] += temp / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i:result) if (!(sb.length()==0&&i==0)) sb.append(i);
        return sb.toString();
    }
}
