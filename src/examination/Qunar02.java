package examination;

import java.util.Scanner;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/12
 * time        : 16:34
 * description :
 */
public class Qunar02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.next();
        String post = scanner.next();
        dfs(in, post);
        System.out.println(sb.toString());
    }
    public static StringBuilder sb = new StringBuilder();
    public static void dfs(String in, String post) {
        if (in == null || in.length() == 0) return;
        char first = post.charAt(post.length() - 1);
        sb.append(first);
        int index = in.indexOf(first);
        String inLeft = in.substring(0, index);
        String inRight = in.substring(index + 1);
        String postLeft = post.substring(0, inLeft.length());
        String postRight = post.substring(inLeft.length(), post.length() - 1);
        dfs(inLeft, postLeft);
        dfs(inRight, postRight);
    }
}
