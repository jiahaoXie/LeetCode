package 腾讯.SummerPractice2017;

import java.util.Scanner;

/**
 * 构造回文  DP做
 * 思想：回文串的特点是，逆序输出和正序输出是一样的。所以这道题可以从这方面来考虑。
 * 如果将此字符串逆序输出，那么两个字符串的最长公共子序列将是最长的回文字符串，那么剩余的值将是要删除的字符个数。
 *
 * @author xjh 2019.04.04
 */
public class test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            if (str.equals("a")) break; //本地测试
            System.out.println(str.length() - getResult(str));
        }
    }

    public static int getResult(String str) {
        StringBuffer sb = new StringBuffer(str);
        String reverse = sb.reverse().toString();
        char[] c1 = str.toCharArray();
        char[] c2 = reverse.toCharArray();
        int n = str.length();
        int[][] dp = new int[n][n];
        //处理边界
        for (int j = 0; j < n; j++) {
            if (c1[0] == c2[j]) dp[0][j] = 1;
            else if (j != 0) dp[0][j] = dp[0][j - 1];
            else dp[0][j] = 0;
        }
        for (int j = 0; j < n; j++) {
            if (c1[j] == c2[0]) dp[j][0] = 1;
            else if (j != 0) dp[j][0] = dp[j - 1][0];
            else dp[j][0] = 0;
        }

        //dp过程
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (c1[i] == c2[j]) {
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1] + 1));
                } else dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }
        return dp[n - 1][n - 1];
    }
}
