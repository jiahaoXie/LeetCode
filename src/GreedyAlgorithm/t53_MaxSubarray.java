package GreedyAlgorithm;

/**
 * leetcode 53 Mximum Subarray
 * @author xjh 2019.03.10
 * 利用两个临时变量存储当前遍历的大于0的数 和已知最大值
 */
public class t53_MaxSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length==1) return nums[0]; //处理边界条件
        int tSum,maxSum;
        tSum=maxSum=nums[0];
        for (int i=1;i<nums.length;i++){
            tSum=tSum>0?tSum+nums[i]:nums[i];
            maxSum=Math.max(maxSum,tSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        t53_MaxSubarray xjh=new t53_MaxSubarray();
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(xjh.maxSubArray(nums));
    }
}
