package 字节跳动;

import java.util.*;

public class RecursionTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[][] a = new int[m][m];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++)
                // 初始化二位数组
                a[i][j] = sc.nextInt();
        }
        // 开始进行遍历 以a[0][0]开始进行向右和向下的遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++)
                // 逐行开始寻找 找到第一个为1的元素
                if (a[i][j] == 1) {
//					int right=j;
//					int down=i;
                    check(a, i, j, m);    //a[0][o]=1 i=j=1
                    count++;
                }

//			count++;
        }
        System.out.println(count);

    }

    // 写一个子函数 判断当前元素是否为1
    public static void check(int[][] a, int i, int j, int m) {
        if (a[i][j] == 1) {
            a[i][j] = 2;
            int right = j;
            int down = i;
            if (i < m && right < m - 1 && j < m && down < m - 1) {
                check(a, i, ++right, m);    //先向右遍历
                check(a, ++down, j, m);    //在向下遍历
            }

        }

    }

}
