package 腾讯.t20190901;
import java.util.Scanner;

public class 花匠小Q {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[t];
        int b[] = new int[t];
        for (int i = 0; i < t; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            int res = 0;
            for (int j = a[i]; j <= b[i]; j++) {
                int tmp = j / k;
                for (int l = 0; l <= tmp; l++) {
                    int white = k * l;
                    int red = j - white;
                    white = white == j ? 0 : 1;
                    red = red == j ? 0 : red;
                    int temp = merge(red + 1, 1);
                    res += temp;
                }
            }
            System.out.println(res);
        }
    }
    /**
     * 组合数,C(n,m) = A(n,m)/m!
     */
    public static int merge(int n, int m) {
        int factM = 1;
        for (int i = 1; i <= m; i++) {
            factM *= i;
        }

        int mul = 1;
        for (int i = n - m + 1; i <= n; i++) {
            mul *= i;
        }
        return mul / factM;
    }

}