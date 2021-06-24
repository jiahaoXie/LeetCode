package 阿里巴巴;

import java.util.Scanner;

/**
 * @author xjh 2019.08.30
 */
public class test1 {
    public static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                a[i][j] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) dfs(a, i, j);
            }
        }
        System.out.println(count);
    }

    public static void dfs(int[][] a, int i, int j) {
        if (i < 0 || i >= a.length - 1 || j < 0 || j >= a[0].length - 1) return;
        if (a[i][j + 1] == 1 && a[i + 1][j] == 1 && a[i + 1][j + 1] == 1) {
            count++;
            a[i][j] = a[i][j + 1] = a[i + 1][j] = a[i + 1][j + 1] = 0;
        }
    }
}
