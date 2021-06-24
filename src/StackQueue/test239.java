package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 239 Sliding Window Maximum
 * 难题~
 *
 * @author xjh 2018.11.04
 */
public class test239 {
    public static void main(String[] args) {

    }

    public static int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n - k + 1];   //用来存放每一次滑动窗口的最大值
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();  //使用双端队列 存储数组元素的下标
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {  //这里表示真正的数组元素开始滑动了
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();   //出队队尾元素
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
                //每一次滑动窗口的最大值始终是队头的元素
            }
        }
        return r;
    }
}
