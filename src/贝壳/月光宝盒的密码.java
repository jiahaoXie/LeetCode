package 贝壳;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 时间复杂度太高 O(n^2)
 */
public class 月光宝盒的密码 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int [] a=new int[n];
        for (int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        int res=DP(a);
        System.out.println(res);
    }

    public static int DP(int[] a){
        int n=a.length;
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
