package 剑指offer_0;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author xjh 2019.04.09
 * 这道题有点难度 需要点技巧 多回顾复习
 */
public class 顺时针打印矩阵 {
    public static ArrayList<Integer> printMatrix(int[][] array) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = array.length, m = array[0].length;
        if (n == 0 || m == 0) return result;
        int layers = (Math.min(n, m) - 1) / 2 + 1;//这个是层数
        for (int i = 0; i < layers; i++) {
            for (int k = i; k < m - i; k++) result.add(array[i][k]);//左至右
            for (int j = i + 1; j < n - i; j++) result.add(array[j][m - i - 1]);//右上至右下
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--) result.add(array[n - i - 1][k]);//右至左
            for (int j = n - i - 2; (j > i) && (m - i - 1 != i); j--) result.add(array[j][i]);//左下至左上

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] matrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = in.nextInt();
        }
        ArrayList<Integer> res = printMatrix(matrix);
        System.out.println(res);
    }
}
