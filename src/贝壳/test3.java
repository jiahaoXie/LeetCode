package 贝壳;

import java.util.Arrays;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        double[] w = new double[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextDouble();
        }
        Arrays.sort(w); //首先排序
        for (int i = 0; i < n - 1; i++) {
            int tmp = n - 1;
            if (w[i] >= w[tmp] * 0.9) count += n - 1 - i;
            else count += midFind(w, w[i] / 0.9) - i;
        }
        System.out.println(count);
    }

    public static int midFind(double[] w, double target) {
        int n = w.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (w[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l;
    }
}
