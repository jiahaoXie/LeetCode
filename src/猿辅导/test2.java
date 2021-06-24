package 猿辅导;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), s = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        int[] temp = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        temp[n - 1] = a[n - 1];
        map.put(n - 1, n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (temp[i + 1] < 0) {
                temp[i] = a[i] + temp[i + 1];
                map.put(i, map.get(i + 1) + 1);
            } else {
                temp[i] = a[i];
                map.put(i, i);
            }
        }

        int result = 0, sum = 0, end = 0;
        for (int i = 0; i < n; i++) {
            while (end < n && sum + temp[end] <= s) {
                sum += temp[end];
                end = map.get(end) + 1;
            }
            result = Math.max(result, end - i);
            sum -= end > i ? a[i] : 0;
            end = Math.max(end, i + 1);
        }
        System.out.println(result);
    }
}
