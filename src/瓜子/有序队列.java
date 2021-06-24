package 瓜子;

import java.util.Arrays;
import java.util.Scanner;

/**
 * leetcode 899 有序队列
 */
public class 有序队列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int k = in.nextInt();
        if (k == 1) {
            String res = s;
            for (int i = 0; i < s.length(); ++i) {
                String temp = s.substring(i) + s.substring(0, i);
                if (temp.compareTo(res) < 0) res = temp;
            }
            System.out.println(res);
            ;
        } else {
            char[] str = s.toCharArray();
            Arrays.sort(str);
            System.out.println(new String(str));
        }
    }
}
