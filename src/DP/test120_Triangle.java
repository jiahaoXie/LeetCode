package DP;

import java.util.List;

/**
 * leetcode 120 Triangle
 *
 * @author xjh 2019.01.15
 * 这个题目就是之前写过的杨辉三角的题目 只不过输入换成了list
 */
public class test120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        //首先定义一个二维的状态转换数组 中间的值存储的是当前走过的路径
        int[][] states = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        //初始化 值都为-1
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < states[0].length; j++)
                states[i][j] = -1;
        }
        states[0][0] = triangle.get(0).get(0);
        //DP的过程如下： 画图便能得到
        // 第一列元素对应的状态值只会是运动方向向下得到的 states[i][0]=states[i-1][0]+tri[i][0]
        //中间位置的states[i][j] 可以由[i-1][j-1]和[i-1][j-1]较小的值得到
        // 每一行的最后一个元素[i][j]由[i-1][j-1]得到
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) states[i][j] = states[i - 1][j] + triangle.get(i).get(j);
                else if (j == triangle.get(i).size() - 1) states[i][j] = states[i - 1][j - 1] + triangle.get(i).get(j);
                else states[i][j] = Math.min(states[i - 1][j - 1], states[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        //输出最小值 也就是二维数组中最后一行中的最小值
        int minV = Integer.MAX_VALUE;
        for (int j = 0; j < states[triangle.size() - 1].length; j++) {
            if (minV > states[triangle.size() - 1][j]) minV = states[triangle.size() - 1][j];
        }
//        System.out.println(minV);
        return minV;
    }
}
