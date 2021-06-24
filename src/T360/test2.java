package T360;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        for (int i = 0; i < n; i++) b[i] = in.nextInt();
//        int[] res=new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < a.length; i++) {
            int max = 0, p = 0;
            for (int j = 0; j < b.length; j++) {
                if (visited[j] == true) continue;
                if (j == 0) {
                    p = 0;
                    max = (a[i] + b[j]) % m;
                } else {
                    if (max < (a[i] + b[j]) % m) {
                        max = (a[i] + b[j]) % m;
                        p = j;
                    }
                }
            }
            a[i] = max;
            visited[p] = true;
        }
        Arrays.sort(a);
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0) System.out.print(a[i]);
            else System.out.print(a[i] + " ");
        }
    }
}
