package 快手2019;

import java.util.Scanner;

/**
 * 快手春招实习笔试 第三道题
 * 32bit的十进制 转成二进制数 有多少个1
 *
 * @author xjh 2019.03.30
 */
public class test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 49)   //字符1的ascii码为49
                count++;
        }
        System.out.println(String.valueOf(count));
//            String str=null;
//            str.concat("abc");
//            str.concat("123");
//            System.out.println(str);
    }
}
