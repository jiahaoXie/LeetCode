package Array;

import java.util.Scanner;

/**
 * 最佳股票买卖时间
 * 这里 用的解决方法的方法3 只考虑每一段的收入 叠加（即只考虑a[i+1]>a[i]的情况）
 * @author xjh  2018.10.15
 */
public class test122_best_time_buy_sell {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[] prices={7,1,5,3,6,4};
//        for(int i=0;i<prices.length;i++){
//            prices[i]=in.nextInt();
//        }
        System.out.println(maxProfit(prices));
    }
    public  static int maxProfit(int[] prices){
       int profit=0;
       for(int i=1;i<prices.length;i++){
           if(prices[i]>prices[i-1]){
               profit+=prices[i]-prices[i-1];
           }
       }
       return  profit;

    }
}
