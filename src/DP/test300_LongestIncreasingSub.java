package DP;

import java.util.Arrays;

/**
 * @author xjh 2019.06.10
 */
public class test300_LongestIncreasingSub {
    public static void main(String[] args) {
        test300_LongestIncreasingSub xjh=new test300_LongestIncreasingSub();
        int[] a={10,9,2,5,3,7,101,18};
        System.out.println(xjh.lengthOfLIS(a));
    }

    //方法1 时间复杂度是O(n^2) 空间复杂度是O(n)
    public int lengthOfLIS(int[] a) {
        int n=a.length;
        if(n==0) return 0;
        if(n==1) return 1;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for (int i=1;i<n;i++){
            for (int j=0;j<i;j++){
                if (a[j]<a[i]) dp[i]=Math.max(dp[i],dp[j]+1);
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

}
