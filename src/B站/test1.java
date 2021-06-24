package B站;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String w1 = in.nextLine();
        String w2 = in.nextLine();
        System.out.println(minDistance(w1, w2));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //首先定义DP状态表
        int[][] dp = new int[m + 1][n + 1];
        //首先处理边界值
        for (int i = 0; i <= n; i++) { //第一行
            dp[0][i] = i;
        }
        for (int i = 0; i <= m; i++) {//第一列
            dp[i][0] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    //两个字符相同 编辑距离等于上一状态
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
//                        dp[i+1][j+1]=min(dp[i][j+1],dp[i+1][j],dp[i][j])+1;
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    //这里依次表示元素插入 删除 替换操作 +1表示当前执行这部操作
                    //dp[i-1][j]可理解为在i位置插入word2[j] dp[i][j-1]可理解为删除原有j位置的元素 dp[i-1][j-1]表示替换原有i j位置上的元素
                }
            }
        }
        return dp[m][n];
    }
}
