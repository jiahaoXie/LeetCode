package GreedyAlgorithm;

/**
 * leetcode 605 Can Place Flowers
 * @author xjh 2019.03.04
 * 判断是否能够种植n朵花：
    * 贪心算法： 首尾相邻两个元素为0时 可种植，中间元素必须相邻3个为0 才能在3者中间元素终止花
 * 快于84.92%
 */
public class t605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0,pre,last;
        for (int i=0;i<flowerbed.length;i++){
            if (flowerbed[i]==1) continue;
            pre=i==0?0:flowerbed[i-1];  //左相邻元素
            last=i==flowerbed.length-1?0:flowerbed[i+1];    //右相邻元素
            if (pre==0&&last==0){
                flowerbed[i]=1;count++;
            }
        }
        return count>=n;
    }
}
