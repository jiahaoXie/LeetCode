package DP;

/**
 * leetcode 121 Best Time to Buy and Sell Stock
 * @author xjh 2019.01.17
 * 121 只能买卖一次股票
 */
public class test121_stock {
    public static int maxProfit(int[] prices) {
        //1.很巧妙的思路 一层循环解决 更新数组里面的最小值 和最大插值
        Integer maxProfit = Integer.MIN_VALUE;
        Integer minPrice = Integer.MAX_VALUE;
        for(Integer price:prices){
            minPrice=Math.min(minPrice,price);
            maxProfit = Math.max(maxProfit,price-minPrice);
        }
        return maxProfit<=0?0:maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        //DP解决问题
        //因为这里只能够买卖一次 有两个维度 i表示天数 j表示当前有无股票（因为这里是买卖只能一次 0表示无买无卖 1表示买 2表示卖）
        //注意 这里如果是可以买卖无数次 j设为0 1就行 0表示当前无股票 1表示当前有股票
        int n=prices.length;
        if(n<=1) return 0;
        int[][] DP=new int[n][3];
        DP[0][0]=DP[0][2]=0; //表示都一天不买股票
        DP[0][1]=-prices[0];    //第一天买股票 买表示手里减去这么多钱
        int res=0;
        for (int i=1;i<n;i++){
            //DP递推公式
            DP[i][0]=DP[i-1][0];  //i天不买不卖
            DP[i][1]=Math.max(DP[i-1][1],DP[i-1][0]-prices[i]);
                //第i天有股票下的最大收益 来自于i-1天有股票 和i-1天无股票i天买的最大值
            DP[i][2]=DP[i-1][1]+prices[i];
                //第i天卖股票
            res=Math.max(res,Math.max(DP[i][1],DP[i][2]));
        }
        return  res;
    }

    public static void main(String[] args) {
        int[] num=new int[]{7,1,5,6,4};
        System.out.println(maxProfit2(num));
    }
}
