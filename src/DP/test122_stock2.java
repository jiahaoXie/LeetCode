package DP;

/**
 * 122 买卖无数次股票
 */
public class test122_stock2 {
    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return  profit;

        //这里DP方法做出来的反而要差一些
        // int n=prices.length;
        // if(n<=1) return 0;
        // int[][] DP=new int[n][2];
        // DP[0][0]=0; //表示都一天不买股票
        // DP[0][1]=-prices[0];    //第一天买股票 买表示手里减去这么多钱
        // for (int i=1;i<n;i++){
        //     //DP递推公式
        //     DP[i][0]=Math.max(DP[i-1][0],DP[i-1][1]+prices[i]);
        //         //第i天没有股票下的最大收益 来自于i-1天同样没股票 和i-1天有股票i天卖掉的最大值
        //     DP[i][1]=Math.max(DP[i-1][1],DP[i-1][0]-prices[i]);
        // }
        // //输出结果 DP[n-1][0]
        // return  DP[n-1][0];
    }
}
