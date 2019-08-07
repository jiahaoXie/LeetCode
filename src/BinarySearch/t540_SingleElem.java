package BinarySearch;

/**
 * leetcode 540 Single Element in a Sorted Array
 * @author xjh 2019.03.11
 * 题干的条件是在一个有序数组中所有元素有两个 只有一个元素m是一个 求出m
 * 这个题的题干要求是在O(logn)时间复杂度下 所以首先想到的是二分查找法
 * 这里有一个很有意思的地方是有p个两个元素的数 所以数组中的总个数是n=2*p+m 他一定是个奇数
 * 利用二分查找算法时 注意每次取得中间元素最好是下标偶数位 这样做的目的是对应两个相同元素的首下标（如果mid之前的元素无单个元素时）
 */
public class t540_SingleElem {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length-1;
        int l=0;
        while (l<n){    //这里只能写成l<n 不能写成l<=n
            int mid=l+(n-l)/2;
            if (mid%2==1) mid--;
            if (nums[mid]==nums[mid+1]){    //表明单独元素不在前半区间里面
                l=mid+2;
            }else{
                n=mid;    //这里只能写n=mid 不能按照二分查找的一贯思路写成n=mid-1
                // 因为nums[mid]！=nums[mid++] 他可能是单独元素 可能是nums[mid-1]=nums[mid]
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        t540_SingleElem xjh =new t540_SingleElem();
        int[] nums={1,1,2,3,3,4,4,8,8};
        System.out.println(xjh.singleNonDuplicate(nums));
    }
}
