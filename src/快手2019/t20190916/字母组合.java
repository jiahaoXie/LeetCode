package 快手2019.t20190916;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * leetcode 17题
 */
public class 字母组合 {
    public static final String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ss = in.nextLine();
        List<String> list = new ArrayList<>();
        backtracking(new StringBuilder(), list, ss);
        System.out.println(list);
    }

    public static void backtracking(StringBuilder pre, List<String> list, String s) {
        if (pre.length() == s.length()) {
            list.add(pre.toString());
            return;
        }
        int cur = s.charAt(pre.length()) - '0';
        String letters = keys[cur];
        for (char c : letters.toCharArray()) {
            pre.append(c);
            backtracking(pre, list, s);
            pre.deleteCharAt(pre.length() - 1);
        }
    }
}
