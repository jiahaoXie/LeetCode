package 腾讯.t20190920;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 最短时间 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        while (n-- > 0) {
            int x = in.nextInt(), y = in.nextInt();
            if (x == 1) list.add(y);
            else {
                for (int i = 1; i <= x; i++) list.add(y);
            }
        }

        Collections.sort(list);
        long max = list.get(0) + list.get(list.size() - 1);
        for (int i = 1, j = list.size() - 2; i < j; i++, j--) {
            long temp = list.get(i) + list.get(j);
            if (max < temp) max = temp;
        }
        System.out.println(max);
    }
}
