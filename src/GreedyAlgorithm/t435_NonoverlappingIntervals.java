package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 435 Non-overlappingIntervals
 * 贪心算法的典型案例：计算让一组区间不重叠所需要移除的区间个数。[经常练习 回顾]
 * 首先需要计算出最多的可不重叠的区间个数m 然后总个数n减去m
 * 计算m 采用贪心算法：我们每次选择的时候，左端点跟前面的已经覆盖的区间不重合的，
    * 右端点又尽量小的，这样可以让剩下的未覆盖区间尽可能的大，就可以放置更多的区间。
 * @author xjh 2019.02.27
 */
public class t435_NonoverlappingIntervals {
     public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public int eraseOverlapIntervals(Interval[] intervals) {
         if (intervals.length==0||intervals.length==1) return 0;
         //1.贪心的第一步 首先需要对区间end进行排序 这里是升序
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end-o2.end;
            }
        });
        //上面这个排序语句 可以用lambda表达式简写为：
        //Arrays.sort(intervals,Comparator.comparingInt(o->o.end));
        //2.计算出m
        int m=1;
        int end=intervals[0].end;
        for (int i=1;i<intervals.length;i++){
            if (intervals[i].start<end) continue;
            end=intervals[i].end;
            m++;
        }
        return intervals.length-m;
    }
}
