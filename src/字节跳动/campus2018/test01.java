package 字节跳动.campus2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class test01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int l = sc.nextInt();
            if (map.containsKey(l)) {
                map.get(l).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(l, list);
            }
        }
        int q = sc.nextInt();
        int[][] qu = new int[q][3];
        for (int i = 0; i < q; i++) {
            qu[i][0] = sc.nextInt();
            qu[i][1] = sc.nextInt();
            qu[i][2] = sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            System.out.println(helper(map.get(qu[i][2]), qu[i][0], qu[i][1]));
        }
    }

    private static int helper(List<Integer> list, int start, int end) {
        if (end < start || list == null) {
            return 0;
        }
        return findr(list, end) - find1(list, start);
    }

    private static int find1(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (list.get(start) >= target) {
            return start - 1;
        }
        if (list.get(end) < target) {
            return end;
        }
        return start;
    }

    private static int findr(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) > target) {
                end = mid;
            }
        }
        if (list.get(end) <= target) {
            return end;
        }
        if (list.get(start) > target) {
            return start - 1;
        }
        return start;
    }
}
