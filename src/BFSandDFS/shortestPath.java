package BFSandDFS;

import javafx.util.Pair;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 求二维数组中原点到某点的最短路径
 * @author xjh 2019.03.17
 */
public class shortestPath {
    final int[][] direction={{-1,0},{1,0},{0,1},{0,-1}};  //表示移动的四个方向
    static int pathLength=0;

    /**
     * BFS 遍历得到最短路径
     * @param grids
     * @param tr
     * @param tc
     * @return
     */
    public int bfsMinPath(int[][] grids,int tr,int tc){
        int m=grids.length,n=grids[0].length;
        Queue<Pair<Integer,Integer>> queue=new LinkedList<>();  //辅助队列
        queue.add(new Pair<>(0,0)); //这里表示从0,0位置开始走 可根据题目需要变化
        while (!queue.isEmpty()){
            int size=queue.size();
            pathLength++;   //长度首先加1
            while (size-->0){
                Pair<Integer,Integer> cur=queue.poll(); //当前元素出队列
                int cr=cur.getKey(),cc=cur.getValue();
                grids[cr][cc]=0;//这里标记 不另外设置visited数组 直接将其值置0即可
                for (int[] d:direction){
                    int nr=cr+d[0],nc=cc+d[1];
                    if (nr<0||nr>m||nc<0||nc>n||grids[nr][nc]==0) continue;
                    if (nr==tr&&nc==tc) return pathLength;
                    queue.add(new Pair<>(nr,nc));
                }
            }
        }
        return -1;
    }

    /**
     * dfs 遍历得到最短路径
     * @param grids
     * @param tr
     * @param tc
     * @return
     */
    public int dfsMinPath(int[][] grids,int tr,int tc){
        int m=grids.length,n=grids[0].length;
//        pathLength=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grids[i][j]=='1'){
                    pathLength++;
                    dfs(grids,i,j,tr,tc);  //dfs递归查找
                }
            }
        }
        return pathLength;
    }
    public void dfs(int[][] grids,int i,int j,int tr,int tc){
        if (i<0||i>grids.length||j<0||j>grids[0].length||grids[i][j]==0) return;    //递归终止条件
        if (i==tr&&j==tc) return;//走到目标位置
        if (grids[i][j]=='1'){
            pathLength++;
            grids[i][j]=0;
            dfs(grids,i-1,j,tr,tc);
            dfs(grids,i+1,j,tr,tc);
            dfs(grids,i,j-1,tr,tc);
            dfs(grids,i,j+1,tr,tc);
        }
    }

    public static void main(String[] args) {
        shortestPath xjh=new shortestPath();
        int[][] grids={{1,1,0,1},
                        {1,0,1,0},
                        {1,1,1,1},
                        {1,0,1,1}}; //初始化的数组中 0表示泵走 1表示可以走
        int bfsMinLen=xjh.bfsMinPath(grids,2,1);
        System.out.println("bfs minlen: "+bfsMinLen);
        int dfsMinLen=xjh.dfsMinPath(grids,2,1);
        System.out.println("dfs minlen: "+dfsMinLen);
    }

}
