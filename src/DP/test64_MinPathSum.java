package DP;

/**
 * @author xjh 2018.08.10
 */
public class test64_MinPathSum {
    // 最粗糙的dp 申请一个额外的二维数组
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) dp[0][i] = dp[0][i - 1] + grid[0][i];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                else dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
