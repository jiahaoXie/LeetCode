package DP;
/**
 *leetcode 123 Best Time to Buy and Sell Stock III
 * @author xjh 2018.01.17
 */
public class test123_stock3 {
    public static int maxProfit(int[] prices){
        //和121第一种方法类似
        int sell1=0,sell2=0,buy1=Integer.MIN_VALUE,buy2=Integer.MIN_VALUE;
        for (int i:prices){
            buy1=Math.max(buy1,-prices[i]);
            sell1=Math.max(sell1,prices[i]+buy1);
            buy2=Math.max(buy2,sell1-prices[i]);
            sell2=Math.max(sell2,buy2+prices[i]);
        }
        return sell2;
    }
    public static int maxProfit2(int[] prices) {
        //这个题目的要求是最多完成2次交易（可以是0 1 2次）
        //DP状态定义时 定义三位数组DP[i][j][k] i表示天数 j表示以交易多少次 k表示当前是否有股票（0无 1有）
        int n=prices.length;
        if (n<=1) return 0;
        int[][][] dp=new int[n][3][2];
        int res=0;
        dp[0][0][0]=0;
        dp[0][0][1]=prices[0];
        dp[0][1][0]=dp[0][1][1]=dp[0][2][0]=dp[0][2][1]=0;
        for (int i=1;i<n;i++){
            //DP过程
            dp[i][0][0]=0;  //当前为0次交易 无股票
            dp[i][0][1]=Math.max(dp[i-1][0][1],dp[i-1][0][0]-prices[i]);    //当前发生了0次交易 现在股票

            dp[i][1][0]=Math.max(dp[i-1][1][0],dp[i-1][1][1]+prices[i]);    //当前发生了一次交易 无股票(不动 或者现在卖)
            dp[i][1][1]=Math.max(dp[i-1][1][1],dp[i-1][1][0]-prices[i]);    //当前发生了一次交易 有股票（不动，或者现在买）

            dp[i][2][0]=Math.max(dp[i-1][2][0],dp[i-1][2][1]+prices[i]);    //当前发生了两次交易 无股票(不动 或者现在卖)
            dp[i][2][1]=0;   //当前两次交易 有股票
        }
        res=Math.max(dp[n-1][1][0],dp[n-1][2][0]);
        return res;
    }
    public static void main(String[] args) {
            int[] num=new int[]{3,3,5,0,0,3,1,4};
            System.out.println(maxProfit(num));
    }
}
