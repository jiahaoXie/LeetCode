package DP;

/**
 * 环形街区抢劫 依旧是不能够连续选择两个相邻的元素 并且数组首尾元素相连
 * rob(i) = Math.max(rob(i - 2) + currentHouseValue, rob(i - 1))
 * @author xjh 2019.06.05
 * 解题思路：数组是首尾相连(选择num[0] 就无法选择num[num.length-1])
 * 我们可疑考虑0~n-2线性选择 和1~n-1线性选择的极大值为本题解
 */
public class test213_HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length==0) return 0;
        int n=nums.length;
        if (n==1) return nums[0];
        return Math.max(max(nums,0,n-2),max(nums,1,n-1));
        //选择数组首下标 就不能选择尾下标；选择尾下标 就只能性下标1开始选
    }
    //相邻的房子不能同时被抢
    public int max(int[] nums,int start,int end){
        int pre2 = 0, pre1 = 0;
        for(int i = start; i <=end; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

}
