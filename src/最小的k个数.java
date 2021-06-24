import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 */
public class 最小的k个数 {
    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(input, 4));
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length == 0 || input.length < k) return res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < input.length; i++) {
            //以下两行简化了大根堆的操作过程
//            maxHeap.add(input[i]);
//            if (maxHeap.size()>k) maxHeap.poll();   //出堆

            //详细过程 作用等同于上面两行
            if (maxHeap.size() < k) maxHeap.add(input[i]);
            else {
                if (maxHeap.peek() > input[i]) {
                    maxHeap.poll();
                    maxHeap.add(input[i]);
                }
            }
        }
        res.addAll(maxHeap);
        Collections.sort(res);
        return res;
    }
}
