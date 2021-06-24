package DP;

/**
 * leetcode 152 Maximum Product Subarray
 *
 * @author xjh 2019.01.15
 * 这道题的题目是在给定的一维数组中寻找最大乘积的子数组（元素必须相邻）
 * 这个需要注意的是 DP的状态方程动议成一维可能不好解决（因为元素有正负 ）
 * 当然也可以定义两个一维数组 max和min
 * 这里还有一点是 状态转换方程dp_max[i]=dp_max[i-1]*nums[i](nums[i]为正数) 或者dp_min[i-1]*nums[i](nums[i]为负数)
 */
public class test152_MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int[] dp_max = new int[nums.length];  //状态转换表的最大数组
        int[] dp_min = new int[nums.length];  //最小数组
        dp_max[0] = dp_min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp_max[i - 1] == 0) {
                dp_max[i] = dp_min[i] = nums[i];
                continue;
            }
            if (nums[i] >= 0) {
                dp_max[i] = Math.max(dp_max[i - 1] * nums[i], nums[i]);
                dp_min[i] = Math.min(dp_min[i - 1] * nums[i], nums[i]);
            } else {
                dp_max[i] = Math.max(dp_min[i - 1] * nums[i], nums[i]);
                dp_min[i] = Math.min(dp_max[i - 1] * nums[i], nums[i]);
            }
        }
        //注意这里得到dp_max状态转换表中的值是包含nums[i]位置的值，所以他并非和以往写的代码一样dp_max[nums.length-1]是全局最大值
        int MAX = Integer.MIN_VALUE;
        for (int i = 0; i < dp_max.length; i++) {
            if (MAX < dp_max[i]) MAX = dp_max[i];
        }
        return MAX;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, -12};
        System.out.println(maxProduct(nums));
    }
}
