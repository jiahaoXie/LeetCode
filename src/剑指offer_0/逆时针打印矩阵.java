package 剑指offer_0;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 和剑指offer上 顺时针打印矩阵类似
 *
 * @author xjh 2019.09.28
 */
public class 逆时针打印矩阵 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                a[i][j] = in.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0;
        while (n > start * 2 && m > start * 2) {
            int row = n - 1 - start;
            int col = m - 1 - start;
            if (row < 0 || col < 0) {
                break;
            }
            for (int i = start; i <= row; i++) list.add(a[i][start]);
            for (int i = start + 1; i <= col; i++) list.add(a[row][i]);
            for (int i = row - 1; i >= start; i--) list.add(a[i][col]);
            for (int i = col - 1; i > start; i--) list.add(a[start][i]);
            start++;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) System.out.println(list.get(i));
            else System.out.print(list.get(i) + " ");
        }
    }
}
