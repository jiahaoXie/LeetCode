package 度小满;

import java.util.Scanner;

public class 传送门 {
    public static int a;
    public static int b;
    public static int c;
    public static int sum = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        int[] array = new int[n + 1];
        for (int i = 1; i < array.length; i++) {
            array[i] = in.nextInt();
        }
        int t = n, res = -1;
        while (res != 1) {
            res = panduan(array, n);
        }
        System.out.println(sum);
    }

    public static int panduan(int[] array, int n) {
        int min = n, minp = -1;
        for (int i = 1; i < array.length; i++) {
            if (Math.abs(min) > Math.abs(n - array[i])) {
                min = n - array[i];
                minp = i;
            }
        }
        sum += a;
        if (min > 0) sum += min * c;
        else sum += Math.abs(min) * b;
        return minp;
    }
}
