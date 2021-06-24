package PriorityQueue;

import java.util.PriorityQueue;

/**
 * 703 Kth Largest Element in a Stream(简单理解就是在n个数据中找到最大的k个数)
 * 这个题有两种解法：
 * 1.利用一个length为k的数组存储k个是最大的元素 利用快排对k个最大数进行排序 总的时间复杂度是n*klogk
 * 2.利用优先队列实现（这里采用Min Heap存储但钱状态最大的k个数 时间复杂度是n*log2 k）
 *
 * @author xjh 2018.11.04
 */
class KthLargest {
    private PriorityQueue<Integer> q;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);       //初始化一个长度为k的优先队列
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || q.size() < k) q.add(nums[i]);
            else if (q.peek() < nums[i]) {
                q.poll();
                q.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (q.size() < k)
            q.add(val);
        else if (q.peek() < val) {
            q.poll();
            q.add(val);
        }
        return q.peek();    //查询队列头部元素
    }
}

public class test703_KthLargest {
}
