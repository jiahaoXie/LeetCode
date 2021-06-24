package 剑指offer_0;

/**
 * 原理是DP
 */
public class 连续子数组的最大和 {
    //方法1 利用两个变量分别保存当前非负子数组的和 当前遍历到的最大值
    //DP的思想
    public int FindGreatestSumOfSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int tSum, maxSum;
        tSum = maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tSum = tSum > 0 ? tSum + nums[i] : nums[i];
            //这行代码的思想 其实就是dp 可理解为dp状态转换方程：dp[i]=Math.max(dp[i-1]+nums[i],nums[i]) 的简写
            maxSum = Math.max(maxSum, tSum);
        }
        return maxSum;
    }
}
