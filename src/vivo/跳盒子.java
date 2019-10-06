package vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 跳盒子 {
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

    private static int solution(int[] input) {
        if (input.length==0) return -1;
        if (input.length==1) return 0;
        int[] dp=new int[input.length+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1]=0;
        for (int i=2;i<dp.length;i++){
            for (int j=1;j<i;j++){
                if (input[i-j-1]>=j) dp[i]=Math.min(dp[i],dp[i-j]+1);
            }
        }
        if (dp[input.length]!=Integer.MAX_VALUE) return dp[input.length];     // TODO Write your code here
        else return -1;
    }
}

