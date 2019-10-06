package vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 运矿石 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] a) {
        int n=a.length;
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=a[i];
        }
        int[][] dp=new int[n+1][sum/2+1];
        for (int i=0;i<n;i++){
            for (int j=1;j<=sum/2;j++){
                dp[i+1][j]=dp[i][j];
                if (a[i]<=j&&dp[i][j-a[i]]+a[i]>dp[i][j]){
                    dp[i+1][j]=dp[i][j-a[i]]+a[i];
                }
            }
        }
        return sum-2*dp[n][sum/2];
    }
}
