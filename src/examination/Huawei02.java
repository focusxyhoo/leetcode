package algorithms;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-14
 * time        : 18:55
 * description :
 */
public class Huawei02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        if (null == s || n == 0) return;
        Deque<Character> stack = new LinkedList<>();
        boolean hasQuote = false;
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char temp = s.charAt(i);
            if (temp != ',') {
                if (temp != '"') {
                    stack.push(temp);
                } else {
                    hasQuote = true;
                    stack.push(temp);
                }
            } else { // if not ',', pop
                if (hasQuote) stack.push(temp);
                else {
                    StringBuilder sb = new StringBuilder();
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb = sb.reverse();
                    String str = sb.toString();
                    if (str.length() == 0) {
                        ans.add("--");
                    } else {
                        if (isIllegal(str)) {
                            if (str.charAt(0) == '"') {
                                ans.add(removeExtra(str.substring(1, str.length() - 1)));
                            } else ans.add(removeExtra(str));
                        } else {
                            return;
                        }
                    }
                }
                hasQuote = false;
            }
        }
        if (!stack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty())
                sb.append(stack.pop());
            sb = sb.reverse();
            String str = sb.toString();
            if (str.length() == 0) {
                ans.add("--");
            } else {
                if (isIllegal(str)) {
                    if (str.charAt(0) == '"') {
                        ans.add(removeExtra(str.substring(1, str.length() - 1)));
                    } else ans.add(removeExtra(str));
                } else {
                    return;
                }
            }
            hasQuote = false;
        }

        System.out.println(ans.size());
        for (String str : ans) {
            System.out.println(str);
        }
    }

    private static boolean isIllegal(String s) {
        int n = s.length();
        if (s.contains(",") || s.contains("\"")) {
            if (s.charAt(0) != '"' || s.charAt(n - 1) != '"') return false;
        }
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == '"') {
                if (i == 0 || i == n - 1) {
                    i++;
                } else {
                    if (s.charAt(i + 1) != '"') return false;
                    i += 2;
                }
            } else i++;
        }
        return true;
    }

    private static String removeExtra(String s) {
        int len = s.length();
        int n = 0;
        if (s.charAt(0) == '"') n = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < len - n; i++) {
            sb.append(s.charAt(i));
            if (s.charAt(i) == '"') i++;
        }
        return sb.toString();
    }
}
