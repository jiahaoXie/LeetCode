package DP;

import java.util.Arrays;

/**
 * leetcode 198 House Robber
 * 题目的主要意思是 不能够连续选择两个相邻的元素 求出
 * 解题思路：DP问题的求解可以概括为一下五步：
 * 1.找到递推关系
 * (也就是我们常说的递推公式 在DP是当前状态值由之前的状态值决定 与后续状态无关 体现DP无后效性特征）
 * 2.递归(自上而下)
 * 3.递归+备忘录(自上而下) 备忘录的作用是减少递归中的重复计算
 * 4.迭代+备忘录(自下而上)
 * 5.迭代+N个变量(自下而上)
 * (这5步是网上大神所归纳总结 2 3 4 5都可以解决问题，这里考虑用第三 四个解决问题
 * 分析题目：强盗有两种选择：a）抢劫当前房屋i; b）不要抢劫目前的房子。
 * 如果选择选项“a”，则意味着她不能抢夺之前的i-1房屋，但可以安全地前往前一个房屋i-2并获得随后的所有累积战利品。
 * 如果选择了一个选项“b”，强盗将从抢劫i-1和以下所有建筑中获得所有可能的战利品。
 * 所以归结为计算更有利可图的东西：
 * 抢劫当前房屋+前一次房屋抢劫
 * 从之前的抢劫案和之前捕获的任何战利品中掠夺
 * 递推公式：rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )
 *
 * @author xjh 2019.01.09
 */
public class test198_HouseRobber {
    //第一种方法：采用递归+备忘录
    public static int rob(int[] nums) {
        int[] memo = new int[nums.length + 1];  //状态转换表
        Arrays.fill(memo, -1);
        return digui(nums, nums.length - 1, memo);  //从后往前递归
    }

    public static int digui(int[] nums, int i, int[] memo) {
        if (i < 0) return 0;
        if (memo[i] >= 0) return memo[i];
        int res = Math.max(digui(nums, i - 2, memo) + nums[i], digui(nums, i - 1, memo));
        memo[i] = res;
        return res;
    }

    //2.DP 采用迭代+备忘录  这种方法好理解！！
    public static int robb(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];  //状态转换方程 每一次存储当前状态的最大值
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
        }
        return memo[nums.length];   //返回值为最后一个元素值
    }

    //3. 相邻的房子不能同时被抢
    //和斐波拉契相似的思路
    public static int rob3(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 9, 1, 5};
//        System.out.println(rob(nums));
        System.out.println(rob3(nums));
    }
}
