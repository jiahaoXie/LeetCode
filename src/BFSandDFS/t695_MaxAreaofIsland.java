package BFSandDFS;

/**
 * leetcode 695. Max Area of Island
 * @author xjh 2019.03.18
 * 利用DFS来解
 */
public class t695_MaxAreaofIsland {
    private int m, n;
    private int[][] direction={{-1,0},{1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;    //边界条件
        n = grid.length;
        m = grid[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max=Math.max(max,dfs(grid,i,j));
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >=n || j < 0 || j >= m || grid[i][j] == 0) return 0;    //递归终止条件
        int count=1;
        grid[i][j] = 0;
        for (int[] d:direction)
            count += dfs(grid,i+d[0],j+d[1]);   //四个方向递归
        return count;//回溯到当前层
    }

    public static void main(String[] args) {
        t695_MaxAreaofIsland xjh =new t695_MaxAreaofIsland();
        int[][] grid={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(xjh.maxAreaOfIsland(grid));
    }
}
