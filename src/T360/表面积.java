package T360;

import java.util.Scanner;

public class 表面积 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] a = new int[n][m];
        int high = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
                if (a[i][j] > 1) high += a[i][j] - 1;
            }
        }
        int di = n * m;
        int sum = 2 * n * m + 2 * (n + high) + 2 * (m + high);
        System.out.println(sum);
    }
}
