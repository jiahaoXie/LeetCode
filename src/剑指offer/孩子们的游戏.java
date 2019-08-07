package 剑指offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 圆圈中最后剩下的数 [十分经典的一道题！！]
 * @author xjh 2019.04.25
 * 用数组来模拟环
 */
public class 孩子们的游戏 {
    public static int LastRemaining_Solution(int n, int m) {
        if (n==1) return n;
        int[] a=new int[n];
        int i=-1,count=n,current=0;    //i=-1表示当前下标未删除的点   count表示未删除的个数和  current表示当前的报数
        while (count>0){//循环跳出时最后一个数 也设置为-1了 结果就是最后一个值为-1的下标
            i++;    //指向上一个删除值的下一个数值
            if (i>=n) i=0;  //构成环
            if (a[i]==-1) continue; //跳过已删除的值
            current++;
            if (current==m){
                a[i]=-1;
                count--;
                current=0;
            }
        }
        return i;
    }

    //Java中LinkedList 简单解决 666
    public static int LastRemaining_Solution2(int n, int m){
        if (n==1) return 1;
        List<Integer> list=new LinkedList<>();
        for (int i=0;i<n;i++) list.add(i);
        int start=0;
        while (list.size()>1){
            start=(start+m-1)%list.size();
            list.remove(start);
        }
        return list.size()>0?list.get(0):0;
    }
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution2(5,2));
    }
}
