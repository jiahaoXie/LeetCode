package 奇安信;
/**
 * 初始邮递兔子，出生后5个月开始每月生一对兔子。求第n月，有多少对兔子
 */

import java.util.Scanner;

public class 兔子出生_斐波拉契问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(compute(n));
    }

    public static long compute(int x) {
        if (x == 1 || x == 2 || x == 3 || x == 4) {
            return 1;
        } else {
            return compute(x - 1) + compute(x - 4);
        }
    }

}
