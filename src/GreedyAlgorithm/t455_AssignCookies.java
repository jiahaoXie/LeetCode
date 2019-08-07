package GreedyAlgorithm;

import java.util.Arrays;

/**
 * leetcode 455 Assign Cookies
 * @author xjh 2019.02.27
 * 贪心算法的典型案例 经常看 经常做！！
 */
public class t455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        //1.首先对两个数组及逆行排序
        Arrays.sort(g);Arrays.sort(s);
        int gi=0,si=0;
        while (gi<g.length&&si<s.length){
            if (g[gi]<=s[si]) gi++; //比较遍历到的最小值
            si++;
        }
        return gi;
    }
}
