package 快手2019.t20190825;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author xjh 2019.08.25
 */
public class 累计平方和 {
    public static boolean flag;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) a[i] = in.nextInt();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            judge(a[i], temp);
            System.out.println(flag);
        }
    }

    //每个数判断
    public static void judge(int t, ArrayList<Integer> temp) {
        if (t == 1) {
            flag = true;
            return;
        }
        if (temp.contains(t)) { //证明不会算出1 已进入死循环
            flag = false;
            return;
        }
        temp.add(t);
        int sum = 0;
        while (t > 9) {
            sum += Math.pow(t % 10, 2);
            t = t / 10;
        }
        sum += Math.pow(t, 2);
        if (sum == 1) {
            flag = true;
            return;
        } else judge(sum, temp);
    }
}

