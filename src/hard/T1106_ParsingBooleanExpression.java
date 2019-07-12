package hard;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-07-05
 * time        : 16:52
 * description : https://leetcode.com/problems/parsing-a-boolean-expression/
 */
public class T1106_ParsingBooleanExpression {

    public static int i; // 注意这个 i 一定要设置为类字段，否则其值无法在迭代过程中传递。

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(parseBoolExpr(s));
        }

    }

    public static boolean parseBoolExpr(String expression) {
        i = 0; // 在每次调用时都要重新设置初值，抹掉之前的值。
        return parse(expression.toCharArray());
    }

    public static boolean parse(char[] chars) {
        char ch = chars[i++]; // 现在 i 指向括号或逗号
        if (ch == 't') return true;
        if (ch == 'f') return false;
        if (ch == '!') {
            i++; // 跳过括号或逗号
            boolean ans = !parse(chars);
            i++; // 每当处理完当前的字符之后，都要将 i 向后移动一位，即跳过逗号或括号。
            return ans;
        }

        boolean isAnd = (ch == '&');
        boolean ans = isAnd;
        i++;

        while (true) {
            if (isAnd) ans &= parse(chars);
            else ans |= parse(chars);
            if (chars[i++] == ')') break;
        }
        return ans;


    }
}
