package 快手2019.t20190916;

import java.util.Scanner;

/**
 * 将数组分成两部分 是的两部分和的差值最小
 *
 * @author xjh 2019.09.16
 */
public class 集合划分问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }
        int[][] dp = new int[n + 1][sum / 2 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                dp[i + 1][j] = dp[i][j];
                if (a[i] <= j && dp[i][j - a[i]] + a[i] > dp[i][j]) {
                    dp[i + 1][j] = dp[i][j - a[i]] + a[i];
                }
            }
        }
        System.out.println(sum - 2 * dp[n][sum / 2]);
    }
}
