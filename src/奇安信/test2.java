package 奇安信;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                g[i][j] = in.nextInt();
        }
        int[] init = new int[2];
        init[0] = in.nextInt();
        init[1] = in.nextInt();
        System.out.println(minSpread(g, init));
    }

    public static int minSpread(int[][] g, int[] init) {
        int[] search = new int[g.length];
        int[] size = new int[g.length];
        for (int i = 0; i < g.length; i++) {
            search[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < g.length; i++) {
            int searchi = search(search, i);
            for (int j = i + 1; j < g.length; j++) {
                if (g[i][j] == 1) {
                    int searchj = search(search, j);
                    if (searchi != searchj) {
                        search[searchj] = searchi;
                        size[searchi] += size[searchj];
                    }
                }
            }
        }
        int max = 0;
        int res = 0;
        for (int i = 0; i < init.length; ++i) {
            int num = size[search(search, init[i])];
            if (num == max) {
                res = res > init[i] ? init[i] : res;
            } else if (num > max) {
                max = num;
                res = init[i];
            }
        }
        return res;
    }

    private static int search(int[] search, int i) {
        while (i != search[i]) {
            i = search[i];
        }
        return i;
    }
}
