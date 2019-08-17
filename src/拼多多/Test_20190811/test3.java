package 拼多多.Test_20190811;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * leetcode 216题类似
 * 这道题的意思是给定两个正整数N和S，找到所有长度为N的正整数序列中，满足单调递增以及总和为S的数列有多少个
 * 输出结果为满足条件的数列个数对100000007取模的结果
 * 回溯法 时间复杂度为指数级 超时 提交为0
 */
public class test3 {
    public static int S;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int s=in.nextInt();
        S=s;
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(n, s, 1, path, combinations);
        System.out.println(combinations.size()%100000007);
    }
    private static void backtracking(int k, int n, int start,List<Integer> tempCombination, List<List<Integer>> combinations) {
        if (k == 0 && n == 0) {
            combinations.add(new ArrayList<>(tempCombination));
            return;
        }
        if (k == 0 || n == 0) {
            return;
        }
        for (int i = start; i <S; i++) {
            tempCombination.add(i);
            backtracking(k - 1, n - i, i + 1, tempCombination, combinations);
            tempCombination.remove(tempCombination.size() - 1);
        }
    }
}
