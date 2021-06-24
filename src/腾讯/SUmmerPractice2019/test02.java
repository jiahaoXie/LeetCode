package 腾讯.SUmmerPractice2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 腾讯暑期实习 第二题 小Q购物
 * 这道题的题干是带尽量少的货币，并且能够组合出1到m之间的所有面值
 * 这道题无需用dp
 *
 * @author xjh 2019.04.06
 */
public class test02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = in.nextInt();
        }
        Arrays.sort(coin);
        int sum = 0, res = 0;
        if (coin[0] != 1) {
            System.out.println(-1);
        } else {
            while (true) {
                if (sum >= m) {
                    System.out.println(res);
                    return;
                }
                for (int i = n - 1; i >= 0; i--) {
                    //这个方法很巧妙 贪心的思想 从面值最大的货币开始 匹配
                    if (coin[i] <= sum + 1) {
                        sum += coin[i];
                        res++;
                        break;
                    }
                }
            }
        }
    }
}
