package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值  这道题有难度
 * @author xjh 2019.04.30\
 * 这道题 可用队列来做 使用linkedList来实现
    滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
*     原则：
*     对新来的元素k，将其与双端队列中的元素相比较
*     1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
*     2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
*     队列的第一个元素是滑动窗口中的最大值
 */
public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        int[] num={2,3,4,2,6,2,5,1};
        ArrayList<Integer> res=maxInWindows(num,3);
        System.out.println(res);
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res=new ArrayList<>();
        if (num==null||size<1) return res;
        LinkedList<Integer> index=new LinkedList<>();
        for (int i=0;i<size-1;i++){ //注意这里是size-1 不是size 否则后面的计算结果会少一个数值
            while (!index.isEmpty()&&num[i]>num[index.getLast()]) index.removeLast();   //只保留当前最大值的下标
            index.addLast(i);   //index这里存储的是数组下标
        }

        for (int i=size-1;i<num.length;i++){
            while (!index.isEmpty()&&num[i]>num[index.getLast()]) index.removeLast();
            index.addLast(i);
            if (i-index.getFirst()+1>size) index.removeFirst();
            res.add(num[index.getFirst()]);
        }
        return res;
    }
}
