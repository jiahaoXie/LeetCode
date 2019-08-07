package DP;

import java.util.Arrays;
/**
 * leetcode 322 Coin Change
 * @author xjh 2019.01.20
 * 注意这道题很容易让人想到直接用贪心算法来求解 实质上贪心有些测试样例是通过不了的
 * 例如 Coin为[2,5,6] amount为15 贪心思想上来就是15!=6*2+2 得不到解
 * 这里选用DP算法来（DPz中最重要的是状态定义（状态转换表）和状态转换方程）
 */
public class test322_CoinChange {
    public static int coinChange(int[] coins, int amount) {
        //定义状态表
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
            //这里dp初始化可选用任何一个大于amount的值取代，不选用Integer.MAX_VALUE来用是因为其太大了
        dp[0]=0;
        for (int i=1;i<dp.length;i++){
            for (int j=0;j<coins.length;j++){
                if (coins[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1); //+1表示当前i状态需要从i-coin[j]走coin[j]这一步
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }

    //一种直观简单的方法
    public static int coinChange2(int[] coin,int amount){
        if (amount==0||coin==null||coin.length==0) return 0;
        int[] dp=new int[amount+1];
        for (int c:coin){
            for (int i=c;i<=amount;i++){
                //01 背包问题中的逆序遍历改为正序遍历
                if (i==c) dp[i]=1;
                else if (dp[i]==0&&dp[i-c]!=0) dp[i]=dp[i-c]+1;
                else if (dp[i-c]!=0) dp[i]=Math.min(dp[i],dp[i-c]+1);
            }
        }
        return dp[amount]==0?-1:dp[amount]; //这里是为了处理边界条件
    }

    public static void main(String[] args) {
        int[] coins=new int[]{2,5,6};
        int amount=15;
        System.out.println(coinChange2(coins,amount));
    }
}
