package PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * leetcode 215 Kth Largest Element in an Array
 * @author xjh 2019.02.24
 * 求解一个数组中的第K大元素 可以用快排 也可以用堆排序（优先考虑堆排序）
 */
public class t215_KthLargestElement {
    //1. 直接Arrays.sort() 代码快于95.57%
    public static int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);  //时间复杂度是O(nlogn) 空间复杂度是O(k)
        return nums[nums.length-k];
    }

    //2.利用堆排序来解 这里是找第k大 所以用小根堆(堆顶元素小于等于堆中的值)
    //时间复杂度是O(nlogn) 空间复杂度是O(1)  奇怪的是堆排序方法2虽然ac,但是性能没有方法1好 才48.55%
    public static int findKthLargest2(int[] nums, int k) {
        Queue<Integer> queue= new PriorityQueue<>();    //用优先队列创建小根堆
        for (int val:nums){
            queue.add(val); //入队
            if (queue.size()>k) queue.poll();   //出队
        }
        return queue.element(); //输出堆顶元素
    }

    //使用快排来实现 在这个问题里 快排的时间复杂度不是O(nlogn) 而是O(n) 因为是n+n/2+....+1
    public static int findKthLargest3(int[] nums,int k){
        k=nums.length-k;
        int l=0,h=nums.length-1;
        while (l<h){
            int j=partition(nums,l,h);
            if (j==k) break;
            else if (j<k) l=j+1;
            else h=j-1;
        }
        return nums[k];
    }
    public static int partition(int[] a,int p,int r){
        //这里写一个好简单的分区函数（每次子数组中的首个元素作为分区点）
        int pivot=a[p];
        while (p<r){
            while(p<r&&a[r]>=pivot) --r;
            a[p]=a[r];  //从后往前遍历 找到小于分区点的值 将其移动到分区点的左侧
            while (p<r&&a[p]<=pivot) ++p;
            a[r]=a[p];  //从前往后遍历，找到大于分区点的值 将其移动到右侧
        }
        a[p]=pivot;
        return p;
    }

    public static void main(String[] args) {
        int[] nums={3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest2(nums,4));
    }
}
