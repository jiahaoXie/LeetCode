package GreedyAlgorithm;

/**
 * leetcode 665 Non-decreasing Array
 *
 * @author xjh 2019.03.08
 * 贪心算法：当nums[i-1]>nums[i]时考虑两种情况
 * 1.优先考虑变小num[i-1] 因为盲目的nums[i]变大 可能使后面元素出现递减的可能性更高
 * 2.如果nums[i-2]>nums[i] 这是选择变大num[i] 不然的话 就需要变换两次
 * 这道题的解题思想很难想到~~
 */
public class t665_NonDescArray {
    //这道题和605的思路很类似 某个数比较前后两个数的大小关系
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) { //出现递减关系
                count++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) nums[i - 1] = nums[i];   //优先考虑变小nums[i-1]
                else nums[i] = nums[i - 1]; //变大nums[i]
            }
        }
        return count <= 1;
    }
}
