package 头条.Test_20190915;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 和不超过k的三个数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        String[] ss = s.split(" ");
        int[] a = new int[ss.length];
        for (int i = 0; i < a.length; i++) a[i] = Integer.valueOf(ss[i]);
        int k = in.nextInt();
        List<List<Integer>> res = combinationSum(a, k);
        System.out.println(res.size());
    }

    public static List<List<Integer>> combinationSum(int[] a, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtracking3(res, temp, a, 0, 3, n);
        return res;
    }

    public static void backtracking3(List<List<Integer>> res, List<Integer> temp, int[] a, int start, int k, int n) {
        if (k == 0) {
            if (n > 0) res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < a.length; i++) {
            temp.add(a[i]);
            backtracking3(res, temp, a, i + 1, k - 1, n - a[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
