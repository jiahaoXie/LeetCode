package 快手2019.t20190916;

import java.util.Arrays;
import java.util.Scanner;

public class 最长等差数列 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for (int i=0;i<n;i++)a[i]=in.nextInt();
        Arrays.sort(a);  //先升序排列
        int diffMax=a[n-1]-a[0];

        int[][] dp=new int[n][diffMax+1];
        for (int i=0;i<n;i++){
            for (int j=0;j<=diffMax;j++)
                dp[i][j]=1;
        }
        int longLength=1;
        for (int i=1;i<n;i++){
            for (int j=i-1;j>=0;j--){
                int t=a[i]-a[j];
                dp[i][t]=dp[j][t]+1;
                longLength=Math.max(longLength,dp[i][t]);
            }
        }
        System.out.println(longLength);
    }
}
