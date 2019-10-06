package 瓜子;

import java.util.Scanner;

/**
 * leetcode 91原题
 */
public class 解码问题 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        if (s==null||s.length()==0) System.out.println(0);;
        int[] dp=new int[s.length()+1];
        dp[0]=1;    //哨兵作用
        dp[1]=s.charAt(0)=='0'?0:1; //dp[1]的输出
        for (int i=2;i<=s.length();i++){
            //这题的关键在于 正确写出dp方程
            int one=Integer.valueOf(s.substring(i-1,i));    //substring(s,e) 包前不包后
            if (one!=0) dp[i]+=dp[i-1];
            if (s.charAt(i-2)=='0') continue;
            int two=Integer.valueOf(s.substring(i-2,i));
            if (two<=26) dp[i]+=dp[i-2];
        }
        System.out.println(dp[s.length()]);
    }
}
