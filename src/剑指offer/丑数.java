package 剑指offer;

import java.util.ArrayList;
/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author xjh 2019.04.16
 * 根据题意推断出 1 2 3 4 5 6前6个数都是丑数，后面的丑数排序得到
 */
public class 丑数 {
    public int GetUglyNumber_Solution(int index) {
        if (index<7) return index;  //前6个数 直接输出
        ArrayList<Integer> res=new ArrayList<>();
        res.add(1);
        //p2,p3,p5分别为2 3 5三个指针，从中选出最小值加入list中
        int p2=0,p3=0,p5=0;
        while (res.size()<index){
            int current= Math.min(res.get(p2)*2,Math.min(res.get(p3)*3,res.get(p5)*5));
            //指针更新 向后移动
            if (res.get(p2)*2==current) p2++;
            if (res.get(p3)*3==current) p3++;
            if (res.get(p5)*5==current) p5++;

            res.add(current);
        }
        return res.get(index-1);
    }
}
