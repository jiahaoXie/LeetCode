package Backtracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * leetcode 52 N-Queues 2
 *
 * @author xjh 2019.01.06
 * N皇后的第二题 和第一题创痛方法很类似
 * 因为52题的输出是一个数值 这里利用位运算的思路来写 性能更快！ 99.5%
 */
public class test52_NQueues2 {
    public static int count = 0;

    //方法一 利用位运算 有点难懂~
    public static int totalNQueens(int n) {
        DFS(n, 0, 0, 0, 0);
        return count;
    }

    public static void DFS(int n, int row, int col, int pie, int na) {
        //递归终止条件
        if (row == n) {
            count += 1;
            return;
        }
        int bits = (~(col | pie | na) & ((1 << n) - 1));
        //得到有效空位
        // ~(col|pie|na)这里除了包含n位(如果是8皇后问题 就是8x8的二位数组 在这里也就是8位)里面有效的空位 32位中大于n位的部分也变成了1
        //所以 上面的数组和((1<<n)-1)与运算 得到正确的n位里面有效的空位
        while (bits > 0) {
            int p = bits & (-bits); //得到最低位的1（1表示空位 注意是-bits（bits取反在加1）不是~(bits)）
            //递归 并要更新位置
            DFS(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            bits = bits & (bits - 1);
        }
    }

    //方法2 hashset保存找你噶金结果 利用回溯算法来解决
    //回溯算法记录行 列 对角线 和反对角线（对角线 相加之和始终相等 反对角线相减之差始终相等）
    public static int totalNQueens2(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        backtrack(0, n, col, pie, na);
        return count;
    }

    public static boolean backtrack(int i, int n, Set<Integer> col, Set<Integer> pie, Set<Integer> na) {
        if (i == n) return true;
        for (int j = 0; j < n; j++) {
            if (!col.contains(j) && !pie.contains(i + j) && !na.contains(i - j)) {
                col.add(j);
                pie.add(i + j);
                na.add(i - j);
                if (backtrack(i + 1, n, col, pie, na)) count += 1;
                col.remove(j);
                pie.remove(i + j);
                na.remove(i - j);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int output = totalNQueens(input);
        System.out.println(output);
    }
}

