package 奇安信;

import java.util.Scanner;

/**
 * @author xjh 2020.2.29
 */
public class 字符串转换 {
    public static String ss = "";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String t = input.substring(1, input.length() - 1);
        recursion(t, 0, 0, ss);
        System.out.println(ss);
    }

    public static void recursion(String t, int i, int length, String ss) {
        if (i == 0 || (t.charAt(i) >= 'a' && t.charAt(i) <= 'z') || (t.charAt(i) >= 'A' && t.charAt(i) <= 'Z'))
            ss += t.charAt(i);
        else if (i == t.length() - 1) {
            ss += t.charAt(i);
            return;
        } else if (t.charAt(i) == '[') {
            ss += '\n';
            length++;
        } else if (t.charAt(i) == ']') {
            ss += '\n';
            length--;
        } else if (length != 0 && t.charAt(i) == ',') {
            ss += '\n';
        }
        recursion(t, i + 1, length, ss);
    }
}
