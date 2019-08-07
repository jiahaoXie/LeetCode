package DP;

/**
 * 左上到右下有多少种走法？
 * @author xjh 2019.06.05
 * dp方程：dp[i][j]=dp[i-1][j]+dp[i][j-1]
 */
public class test62_UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i=0;i<n;i++){
            dp[0][i]=1; //第一行只有一种走法
        }
        for (int i=1;i<m;i++){
            for (int j=0;j<n;j++){
                //第一列都是1 只能向下得到
                if (j==0) dp[i][j]=1;
                else dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        test62_UniquePaths xjh=new test62_UniquePaths();
        System.out.println(xjh.uniquePaths(7,3));
    }
}
