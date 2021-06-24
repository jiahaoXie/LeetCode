package 华为;

import java.util.Scanner;

/**
 * 华为笔试第一题 判断字符串是否为双对称字符串
 */
public class t0424_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.equals("0")) break;
            boolean flag = true;
            //1. 长度为偶数
            if (s.length() % 2 != 0) {
                System.out.println("false");
                continue;
            }
            //2. 判断12相同 34相同
            for (int i = 0; i < s.length() - 1; ) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    flag = false;
                    break;
                }
                i = i + 2;
            }
            if (flag == false) {
                System.out.println("false");
                continue;
            }
            //3.判断是否回文
            for (int j = s.length() / 2, k = j - 1; k >= 0 && j <= s.length() - 1; k--, j++) {
                if (s.charAt(j) != s.charAt(k)) {
                    flag = false;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("false");
                continue;
            }
            //否则输出 结果
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i = i + 2)
                sb.append(s.charAt(i));
            System.out.println(sb.toString());
        }
    }
}
