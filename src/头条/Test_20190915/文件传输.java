package 头条.Test_20190915;

import java.util.Scanner;

public class 文件传输 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][2];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
            sum += a[i][1];
        }
        int res = 0, max = 1;
        for (int i = 0; i < n; i++) {
            res += a[i][1];
            max = Math.max(res, max);
            res -= 1;
        }
        System.out.println((sum + 1) + " " + max);
    }
}
