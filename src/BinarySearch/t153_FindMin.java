package BinarySearch;

/**
 * leetcode 153 Find Minimum in Rotated Sorted Array
 *
 * @author xjh 2019.03.12
 */
public class t153_FindMin {
    //有序数组被旋转了一下 利用二分查找在O(logn)的时间复杂度内完成
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        //方法1 利用最简单的遍历 直接遍历到小于原头节点
//        int i,j;
//        for (i=0,j=1;j<nums.length;i++,j++){
//            if (nums[i]>nums[j]) return nums[j];
//        }
//        return nums[0];

        //方法2 利用二分查找来解 O(logn)
        int n = nums.length - 1;
        int l = 0;
        while (l < n) {        //这里只能写成l<n
            int mid = l + (n - l) / 2;
            if (nums[mid] <= nums[n]) n = mid;      //中间元素小于末尾元素 说明头元素在前半段
            else l = mid + 1;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        t153_FindMin xjh = new t153_FindMin();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(xjh.findMin(nums));
    }
}
