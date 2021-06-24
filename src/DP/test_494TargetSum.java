package DP;

import java.util.Arrays;

/**
 * 这道题 更像是一道用回溯算法来解决的题目
 *
 * @author xjh 2019.06.17
 */
public class test_494TargetSum {
    //1.回溯算法 暴力解决 这里没有对递归过程做任何优化处理
    //时间复杂度是O(2^n) 空间复杂度是O(n)【递归树的高度可到n】
    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        backtracking(nums, 0, 0, S);
        return count;
    }

    public void backtracking(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) count++;
        } else {
            backtracking(nums, i + 1, sum + nums[i], S);   //加
            backtracking(nums, i + 1, sum - nums[i], S);   //减
        }
    }

    //2. 回溯算法优化 递归加备忘录 避免递归中重复计算
    //具体而言,这里的时间复杂度是O(l*n) l为sum的取值范围，n为num数组的大小
    //空间复杂度为O(n*l)
    public int findTargetSumWays2(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] row : memo) Arrays.fill(row, Integer.MIN_VALUE);
        return calculate(nums, 0, 0, memo, S);
    }

    public int calculate(int[] nums, int i, int sum, int[][] memo, int S) {
        if (i == nums.length) {
            if (sum == S) return 1;
            else return 0;
        } else {
            if (memo[i][sum + 1000] != Integer.MIN_VALUE) return memo[i][sum + 1000];
            int add = calculate(nums, i + 1, sum + nums[i], memo, S);
            int sub = calculate(nums, i + 1, sum - nums[i], memo, S);
            memo[i][sum + 1000] = add + sub;
            return memo[i][sum + 1000];
        }
    }


}
