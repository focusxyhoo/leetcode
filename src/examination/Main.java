package examination;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-15
 * time        : 15:34
 * description : netease interview
 * no question asked
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        Deque<Character> stack = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            Character temp = s.charAt(i);
            if (temp == ']') { // 出栈
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop(); // 删除 [
                sb = sb.reverse();
//                System.out.println("1 " + sb.toString());
                String newStr = core(sb.toString());
//                System.out.println("2 " + newStr);
                for (char c : newStr.toCharArray()) {
                    stack.push(c);
                }
            } else stack.push(temp);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result = result.reverse();
        System.out.println(result.toString());
    }

    public static String core(String s) {
        int index = s.indexOf('|');
        if (index == -1) return null;
        int n = Integer.parseInt(s.substring(0, index));
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            result.append(s.substring(index + 1));
            n--;
        }
        return result.toString();
    }
}
