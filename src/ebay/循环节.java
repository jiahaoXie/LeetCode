package ebay;

import java.util.Scanner;

/**
 * @author xjh 2019.09.25
 */
public class 循环节 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] res = new char[s.length()];
        for (int i = 0; i < res.length; i++) res[i] = '0';
        boolean flag = true;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            String temp = s.substring(0, i);
            if (judge(s, temp)) {
                if (flag) {
                    //表示第一次
                    for (int k = 0; k < temp.length() - 1; k++) res[k] = '0';
                    res[temp.length() - 1] = '1';
                    flag = false;
                    max = temp.length();
                } else {
                    for (int k = max; k < temp.length() - 1; k++) res[k] = '0';
                    res[temp.length() - 1] = '1';
                    max = temp.length();
                }
            }
        }
        for (int i = 0; i < res.length - 1; i++) System.out.print(res[i]);
        System.out.println('1');
    }

    //判断temp是否是s的循环节
    public static boolean judge(String s, String temp) {
        int j = 0;
        for (int i = temp.length(); i < s.length(); i++) {
            if (j >= temp.length()) j = 0;
            if (s.charAt(i) != temp.charAt(j)) return false;
            j++;
        }
        return true;
    }
}
