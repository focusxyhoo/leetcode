package leetcode.medium;

import java.util.*;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019-08-19
 * time        : 11:10
 * description :
 */
public class T71_SimplifyPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(simplifyPath(scanner.nextLine()));
    }

    /**
     * 利用 split 函数将字符串按 / 符号切分，然后根据情况加入或者不加入栈。
     * Runtime: 6 ms, faster than 41.13% of Java online submissions for Simplify Path.
     * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Simplify Path.
     *
     * @param path
     * @return
     */
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] p = path.split("/");
        System.out.println(Arrays.toString(p));
        for (int i = 0; i < p.length; i++) {
            if (!stack.empty() && p[i].equals("..")) stack.pop();
            else if (!p[i].equals(".") && !p[i].equals("") && !p[i].equals("..")) stack.push(p[i]);
        }
        List<String> list = new ArrayList<>(stack);
        return "/" + String.join("/", list);
    }
}
