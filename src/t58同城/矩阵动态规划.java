package t58同城;

import java.util.Scanner;

public class 矩阵动态规划 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][m];
        int[][] states = new int[n][m];   ////定义状态转换数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                a[i][j] = in.nextInt();
        }
        DP1(a, n, m, states);
    }

    public static void DP1(int[][] a, int n, int m, int[][] states) {
        //开始写DP过程
        //大多数位置的值states[i][j] 由min(states[i-1][j],states[i][j-1])得到
        //第一行只能往右移动 第一列只能向下移动
        states[0][0] = a[0][0];
        for (int i = 1; i < m; i++) {
            states[0][i] = states[0][i - 1] + a[0][i];    //第一行
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) states[i][j] = states[i - 1][j] + a[i][j];   //第一列
                else {
                    states[i][j] = Math.min(states[i - 1][j], states[i][j - 1]) + a[i][j];
                }
            }
        }
        //输出结果
        System.out.println(states[n - 1][m - 1]);
    }
}
