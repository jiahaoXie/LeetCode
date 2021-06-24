package t58同城;

import java.util.Arrays;
import java.util.Scanner;

public class 计算TP99耗时 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = new int[200];
        for (int i = 0; i < num.length; i++) {
            num[i] = in.nextInt();
        }
        Arrays.sort(num);
        System.out.println(num[197]);
    }
}
