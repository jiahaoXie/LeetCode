package BinarySearch;

/**
 * leetcode 34 Find First and Last Position of Element in Sorted Array
 *
 * @author xjh 2019.03.12
 * 在一个有序的数组中查找指定元素的初始下标和结束下标：
 * 方法一 和方法二都是基于二分查找 实现，要下考虑方法一  尽管代码量大一些 但是简单易懂；方法二 有许多边界条件值得注意
 */
public class t34_FindFirstandLast {
    //方法1 两个函数查找首尾两个下标 纯手怼
    public int[] searchRange(int[] nums, int target) {
        //典型的二分查找
        int first = -1, last = -1;
        first = searchFirst(nums, target);
        last = searchLast(nums, target);
        return new int[]{first, last};
    }

    public int searchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;
            else {   //这里主要是要二分查找到等于给定值的元素的下标和其哪一个元素进行一次判断
                if (mid == 0 || nums[mid - 1] != target)
                    return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    public int searchLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;
            else {   //这里主要是要二分查找到等于给定值的元素的下标和其哪一个元素进行一次判断
                if (mid == nums.length - 1 || nums[mid + 1] != target)
                    return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    //方法2 更加灵活的二分查找思想 只用一个子函数求解下标 网上答案 有点难想到
    //这里我们选择求解给定值target的首下标 和target+1的首下标   当然这里要注意的边界条件也会更多
    public int[] searchRange2(int[] nums, int target) {
        int first = search2(nums, target); //查找等于给定值的首下标
        int last = search2(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) return new int[]{-1, -1};
        else return new int[]{first, Math.max(first, last)};  //Math.max(first,last)是因为防止数组中只有一个元素 last值为-1的情况
    }

    public int search2(int[] nums, int target) {
        int l = 0, n = nums.length;  //这里n初始值不能写成nums.length-1
        while (l < n) {
            int mid = l + (n - l) / 2;
            if (nums[mid] >= target) n = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        t34_FindFirstandLast xjh = new t34_FindFirstandLast();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] res = xjh.searchRange2(nums, 8);
        for (Integer i : res) {
            System.out.print(i + " ");
        }
    }
}
