package 剑指offer_0;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author xjh 2019.09.28
 */
public class 最小的k个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length < k) return res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);//大根堆
        for (int val : input) {
            maxHeap.add(val); //入队
            if (maxHeap.size() > k) maxHeap.poll();   //出队
        }
        for (int i : maxHeap) res.add(i);
        return res;
    }
}
