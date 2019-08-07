package DP;

/**
 * 判断数组中的元素是否可以划分为子数组和相等的两部分
 * @author xjh 2019.06.17
 * 可以将这个问题看成背包大小为sum/2的背包问题
 */
public class test416_PartitionEqualSubsetSum {
    //1. DP方法可能有点难懂
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int num:nums)
            sum+=num;
        if (sum%2!=0) return false;
        int W=sum/2;
        boolean[] dp=new boolean[W+1];
        dp[0]=true;
        for (int num:nums){ //0-1背包中每个物品只能用一次
            for (int i=W;i>=num;i--){   //这里需要从后往前
                dp[i]=dp[i]||dp[i-num];
            }
        }
        return dp[W];
    }

    // 2.利用递归来求解 容易明白一些 同样是递归问题
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0) return false;
        return recursive(nums.length-1,nums,0,sum/2);
    }
    public boolean recursive(int i,int[] nums,int sum,int target){
        if (i<0||sum>target) return false;
        if (nums[i]>target) return false;
        if (sum==target) return true;
        return recursive(i-1,nums,sum+nums[i],target) //将nums[i]放入背包
                ||recursive(i-1,nums,sum,target);       //将nums[i]不放入背包
    }
}
