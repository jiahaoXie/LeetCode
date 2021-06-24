package 字节跳动.test;

import java.util.Scanner;

/**
 * 门禁系统 ccf 2014-12-1
 *
 * @author xjh
 */
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        //开始计数

        for (int i = 0; i < a.length; i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] == a[j])
                    count++;
            }
            System.out.print(count + " ");
        }
    }

}
