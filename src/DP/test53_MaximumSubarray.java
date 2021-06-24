package DP;

/**
 * leetcode 53 最大和子数组
 *
 * @author xjh 2019.01.15
 */
public class test53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int tSum, maxSum;
        tSum = maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tSum = tSum > 0 ? tSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, tSum);
        }
        return maxSum;
    }
}
