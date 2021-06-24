package 招商银行;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 图论 找到有向图中没有出度的节点
 * 网上答案
 * 18年真题编程题
 *
 * @author xjh 2019.04.09
 */
public class test01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]), m = Integer.parseInt(tmp[1]);
        boolean[][] graph = new boolean[n + 1][n + 1];
        while (m-- > 0) {
            tmp = br.readLine().split(",");
            graph[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])] = true;
        }
        br.close();
        boolean[] res = new boolean[n + 1];
        for (int i = 1; i <= n; i++)
            if (!res[i])
                backTrace(graph, i, new HashSet<Integer>(n >> 1), res);
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= n; i++)
            if (!res[i]) out.append(' ').append(i);
        if (out.length() == 0) System.out.println("None");
        else System.out.println(out.substring(1));
    }

    private static void backTrace(boolean[][] graph, int index, Set<Integer> set, boolean[] res) {
        if (set.contains(index)) {
            for (Integer i : set) res[i] = true;
            return;
        }
        set.add(index);
        for (int i = 1; i < graph[0].length; i++)
            if (graph[index][i]) {
                if (res[i])
                    for (Integer inter : set) res[inter] = true;
                else backTrace(graph, i, set, res);
            }
        set.remove(index);
    }
}
