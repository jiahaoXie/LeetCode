package 贝壳;

import java.util.Scanner;

public class test44 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int[] num = new int[n];
        long res = 0;
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        int t = 0;
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i] >= num[i - 1]) {
                t = i;
                break;
            }
        }

        for (int i = 0; i < t - 2; i++) {
            if (num[i] < num[i + 1]) {
                continue;
            } else {
                int sub = num[i] - num[i + 1];
                res += sub + 1;
                num[i + 1] += sub + 1;
            }
        }
        if (t - 2 >= 0 && num[t - 2] >= num[t - 1] && num[t] >= num[t - 1]) {
            int a1 = num[t - 2] - num[t - 1];
            int a2 = num[t] - num[t - 1];
            int min = a1 < a2 ? a1 : a2;
            res += min + 1;
            System.out.println(res);
            return;
        }
        if (t != 0 && num[t] == num[t - 1])
            res += 1;
        System.out.println(res);
    }
}