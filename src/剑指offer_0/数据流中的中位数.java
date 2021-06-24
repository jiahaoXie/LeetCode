package 剑指offer_0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 该题想要考察的是海量数据 求中位数 实质上是想用大小根堆的方法求解
 *
 * @author xjh 2019.04.29
 */
public class 数据流中的中位数 {
    List<Integer> list = new ArrayList<>();

    public void Insert1(Integer num) {
        list.add(num);
    }

    public Double GetMedian1() {
        int n = list.size();
        Collections.sort(list); //进行升序排列
        if (n % 2 == 1) return Double.valueOf(list.get(n / 2));
        else {
            double t1 = Double.valueOf(list.get(n / 2));
            double t2 = Double.valueOf(list.get(n / 2 - 1));
            return (t1 + t2) / 2;
        }
    }

    //方法2 在海量数据中 求解中位数 利用 大根堆加小根堆(大根队中的数据都小于小根堆中的数据)
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    //优先队列中默认是小根堆，改变二者的比较顺序 使其成为大根堆

    public void Insert2(Integer num) {
        if ((count & 1) == 0) {//如果当前数组中有偶数个数,新加入的元素应当进入小根堆
            //不是直接进入小根堆，而是将大根堆中最大的元素加入小根堆
            maxHeap.add(num);
            int curMaxNum = maxHeap.poll();
            minHeap.add(curMaxNum);
        } else {//如果当前数组中有奇数个数,新加入的元素应当进入大根堆
            //和上面同理 不是直接加入大根堆 而是小根堆中的最小值加入大根堆
            minHeap.add(num);
            int curMinNum = minHeap.poll();
            maxHeap.add(curMinNum);
        }
        count++;
    }

    public Double GetMedian2() {
        if ((count & 1) == 0) return new Double((maxHeap.peek() + minHeap.peek()) / 2.0);
        else return new Double(minHeap.peek());
    }
}
