package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 按照平方数来分割整数
 *
 * @author xjh 2019.06.08
 */
public class test279_PerfectSquares {
    public static void main(String[] args) {
        test279_PerfectSquares xjh = new test279_PerfectSquares();
        System.out.println(xjh.numSquares(15));
    }

    public int numSquares(int n) {
        List<Integer> list = getSquareList(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int s : list) {
                if (s > i) break;
                min = Math.min(min, dp[i - s] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    //这个函数 用来求解小于等于n的平方数
    public List<Integer> getSquareList(int n) {
        List<Integer> list = new ArrayList<>();
        int diff = 3, square = 1;
        while (square <= n) {
            list.add(square);
            square += diff;   //下一个平方数
            diff += 2;    //函数的妙处在于总结到 每两个平方数之间差值的规律
        }
        return list;
    }
}
