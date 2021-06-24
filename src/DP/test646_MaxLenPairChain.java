package DP;

import java.util.Arrays;

/**
 * @author xjh 2019.06.10
 */
public class test646_MaxLenPairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null) return 0;
        if (pairs.length == 1) return 1;
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);    //哨兵作用
        int max = 1;
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        //这道题目的关键是 根据边界出错的样例 首先将二维数组种的数据按照首字母升序排序
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
