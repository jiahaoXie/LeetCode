package 拼多多;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题干条件时给定给定m栋楼的高度 想要得到n个高度相同的楼层 求最少徐娅增高的总层数
 *
 * @author xjh 2019.05.07
 * 网上大佬的答案
 */
public class 高楼加层 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            arr.add(x);
        }
        arr.sort(null); //功能是升序排列
//        for (int i:arr) System.out.print(i+" ");
        long s = 0;
        long min = arr.get(m - 1) * n;
        for (int i = 0; i <= m - n; i++) {
            long max = arr.get(i + n - 1);
            if (i == 0) {
                for (int j = i; j < i + n; j++) {
                    s += arr.get(j);
                }
            } else {
                s = s - arr.get(i - 1) + arr.get(i + n - 1);

            }
            //System.out.println("max="+max+"s="+s);
            long x = max * n - s;
            if (x < min) {
                min = x;
            }
        }
        System.out.println(min);
    }
}
