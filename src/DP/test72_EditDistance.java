package DP;

import java.util.Scanner;

/**
 * leetcode 72 Edit Distance
 * @author xjh 2019.01.20
 * 这道题十分经典 一定要搞懂！！
 * 复习时可以结合之前学习到的两种用DP方法实现的编辑距离算法（莱文斯坦距离，最长公共子串）
 * 实质上这道题的解题思路和莱温斯坦距离十分相似
 */
public class test72_EditDistance {
    public static int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        //首先定义DP状态表
        int[][] dp=new int[m+1][n+1];
        //首先处理边界值
        for (int i=0;i<=n;i++){ //第一行
            dp[0][i]=i;
        }
        for (int i=0;i<=m;i++){//第一列
            dp[i][0]=i;
        }

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                    if (word1.charAt(i)==word2.charAt(j)){
                        //两个字符相同 编辑距离等于上一状态
                        dp[i+1][j+1]=dp[i][j];
                    }
                    else {
//                        dp[i+1][j+1]=min(dp[i][j+1],dp[i+1][j],dp[i][j])+1;
                            dp[i+1][j+1]=Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i][j])+1;
                        //这里依次表示元素插入 删除 替换操作 +1表示当前执行这部操作
                        //dp[i-1][j]可理解为在i位置插入word2[j] dp[i][j-1]可理解为删除原有j位置的元素 dp[i-1][j-1]表示替换原有i j位置上的元素
                    }
                }
        }
        return dp[m][n];
    }
    public static int min(int x,int y,int z){
        int min=Integer.MAX_VALUE;
        if (min>x) min=x;
        if (min>y) min=y;
        if(min>z) min=z;
        return min;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
//        String w1=in.nextLine();
//        String w2=in.nextLine();
        String w1="abc";
        String w2="abd";
        System.out.println(minDistance(w1,w2));
//        System.out.println(min(6,8,10));
    }
}
