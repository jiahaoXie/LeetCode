package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 51. N-Queens 这道题难！！
 *
 * @author xjh  2018.12.19
 */
public class test51_N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        //递归从第一行遍历到最后一行（更确切的说 这个是回溯的算法！！）
        //对于每一行放置的皇后 采用剪枝的思想 将他的同行 同列 撇 那 的元素置为1，表示不能放元素
        //递归结束后又将其恢复
        //因为涉及到后续输出
        //这里是答案1
        if (n <= 0) return Collections.emptyList();    //返回空表
        char[][] broad = new char[n][n];
        for (int i = 0; i < broad.length; i++) {
            Arrays.fill(broad[i], '.');  //首先置为.
        }
        DG(broad, 0, list);   //这里的j是指的列
        return list;

        //第二种方法 时间4ms
//        int[][] vis=new int[3][2*n];
//        //vis[0] 用来判断它们是否在同一行上
//        //vis[1] 用来判断是否在对角线上 那（Q1.row-Q1.col == Q2.row-Q2.col或Q1.col-Q1.row == Q2.col-Q2.row）
//        //vis[2] 用来判断是否在反对角线上 撇（Q1.row + Q1.col == Q2.row + Q2.col）
//        DFS(0,n,new int[n],list,vis);
//        return list;
    }

    public void DG(char[][] broad, int j, List<List<String>> list) {
        if (j == broad.length) {
            //已经遍历到最后一行
            List<String> broadList = new ArrayList<>();
            for (int i = 0; i < broad.length; i++) {
                StringBuilder s = new StringBuilder();
                for (int p = 0; p < broad.length; p++)
                    s.append(broad[i][p]);
                broadList.add(s.toString());    //将这一行数据加入list中
            }
            list.add(broadList);
        } else {
            for (int i = 0; i < broad.length; i++) {
                broad[i][j] = 'Q';    //i行j列元素为Q
                if (isValid(broad, j, i)) {
                    //判断其他可插入皇后的合法位置
                    DG(broad, j + 1, list); //递归
                }
                broad[i][j] = '.';
            }
        }

    }

    public boolean isValid(char[][] broad, int j, int i) {
        for (int a = 0; a < j; a++) {
            if (broad[i][a] == 'Q')   //判断同行(具体说是broad[i][0]-broad[i][j-1]) 是否有Q
            {
                return false;
            }
        }
        for (int a = i - 1, b = j - 1; a >= 0 && b >= 0; a--, b--) {  //那(具体说是左上部分)
            if (broad[a][b] == 'Q') {
                return false;
            }

        }
        for (int a = i + 1, b = j - 1; a < broad.length && b >= 0; a++, b--) { //撇（左下部分）
            if (broad[a][b] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public void DFS(int cur, int n, int[] C, List<List<String>> list, int[][] vis) {
        if (cur == n) {
            //遍历结束
            List<String> s = new ArrayList<>();
            int p = 0;
            for (int row = 0; row < n; row++) {
                StringBuilder ssb = new StringBuilder();
                for (int col = 0; col < n; col++) {
                    if (col == C[p]) ssb.append('Q');
                        //这里我好奇的是 C[n]是一个刚初始化的数组 里面的数值全是0啊，这有什么意义？？
                    else ssb.append('.');
                }
                s.add(ssb.toString());
                p++;
            }
            list.add(s);
            return;
        } else {
            //对于正在遍历的每一行  依次访问vis二位数组中对应下标元素
            for (int i = 0; i < n; i++) {
                if (vis[0][i] == 0 && vis[1][cur + i] == 0 && vis[2][cur - i + n] == 0) {
                    //上述依次表示同行 反对角线 对角线(cur-i+n 加n是为了防止下标出现负数)是否会有冲突
                    C[cur] = i;   //选择i列
                    //设置i对应的列 &反对角线& 的主对角线
                    vis[0][i] = vis[1][cur + i] = vis[2][cur - i + n] = 1;

                    DFS(cur + 1, n, C, list, vis);
                    vis[0][i] = vis[1][cur + i] = vis[2][cur - i + n] = 0;
                }
            }
        }
    }

}
