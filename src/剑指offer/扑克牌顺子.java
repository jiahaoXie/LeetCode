package 剑指offer;

/**
 * 这道题 有点巧妙 参考答案做出来的
 * 根据题目的意思进行推断
 * @author xjh 2019.04.23
 * max记录最大值 min记录最小值
 * 顺子满足的条件是： 1.max-min<5;   2.除0外没有重复的数字；   3.数组长度是5；
 */
public class 扑克牌顺子 {
    public boolean isContinuous(int [] numbers) {   //这里number数组就是保存抽取到的5张牌
        if (numbers.length!=5) return false;
        int[] d=new int[14];
        d[0]=-4;    //因为在题干中大小王一共有4张
        int max=-1,min=14;
        for (int i=0;i<numbers.length;i++){
            d[numbers[i]]++;
            if (numbers[i]==0) continue;
            if (d[numbers[i]]>1) return false;
            if (numbers[i]>max) max=numbers[i];
            if (numbers[i]<min) min=numbers[i];
        }
        if (max-min<5) return true;
        else return false;
    }
}
