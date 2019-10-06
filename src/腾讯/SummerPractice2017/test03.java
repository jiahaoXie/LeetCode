package 腾讯.SummerPractice2017;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * 有趣的数字 这道题难 需考虑重复数字
 * 基本思路：先对输入的原数据进行排序 再根据不同情况采用不同算法
 * 差值最大的对数：最小数的个数x最大数的个数
 * 差值最小的对数：1.当序列中无重复关键字时：可知最小差必然产生在相邻元素中，遍历一遍用map保存最小差的对数即可。
                  2.当序列中有重复关键字时：首先确定最小差为0，故而对相同序列的个数依次用排列组合的知识求对数即可。
 网上能够ac的答案
 * @author xjh 2019.04.04
 */
public class test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int [] a = new int[n];
            for (int i = 0; i < n; ++i) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a); //排序
            boolean flag = false;
            int imin = 0, imax = 0;
            for (int i = 0; i < n-1; ++i) {
                if(a[i] == a[i+1])
                    flag = true;    //存在重复数据
                if(a[i] == a[0] && a[i+1] != a[0])
                    imin = i+1; //最小数个数
                if(a[i] != a[n-1] && a[i+1] == a[n-1])
                    imax = n - 1 - i;   //最大数个数
            }

            int mindis = 1000000000;                                                                        ;
            Map<Integer, Integer> map = new TreeMap<>();
            if(flag) {  //flag为true 最小差值mindis为0
                mindis = 0;
                int iequ = 1;
                for (int i = 0; i < n-1; ++i) {
                    if(a[i] == a[i+1]) {
                        iequ++;
                    } else {
                        if (map.containsKey(mindis))
                            map.put(mindis, map.get(mindis)+iequ*(iequ-1)/2);
                        else
                            map.put(mindis, iequ*(iequ-1)/2);
                        iequ = 1;
                    }
                }
                if (iequ > 1) {
                    if (map.containsKey(mindis))
                        map.put(mindis, map.get(mindis)+iequ*(iequ-1)/2);
                    else
                        map.put(mindis, iequ*(iequ-1)/2);
                    iequ = 1;
                }
            } else {
                for (int i = 0; i < n-1; ++i) {
                    if (Math.abs(a[i+1]-a[i]) <= mindis) {
                        mindis = Math.abs(a[i+1]-a[i]);
                        if (map.containsKey(mindis))
                            map.put(mindis, map.get(mindis)+1);
                        else
                            map.put(mindis, 1);
                    }
                }
            }
            System.out.println(map.get(mindis) + " " + imin*imax);
        }
        sc.close();
    }
}


