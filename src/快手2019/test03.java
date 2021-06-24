package 快手2019;

/**
 * 快手春招实习笔试 快手第二道题 机器人
 * 回溯算法
 *
 * @author xjh 2019.03.30
 */
public class test03 {
    public static void main(String[] args) {
        test03 xjh = new test03();
        int res = xjh.movingCount(15, 20, 20);
        System.out.println(res);
    }

    public int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static int count = 0;

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];    //访问标记数组
        dfs(0, 0, threshold, visited);
        return count;

//        return countingSteps(threshold,rows,cols,0,0,visited);
    }

    public void dfs(int i, int j, int threshold, boolean[][] visited) {
        if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length || visited[i][j] || bitSum(i) + bitSum(j) > threshold)
            return;
        //进行判断
        visited[i][j] = true;
        count++;
        for (int[] d : direction) {
            dfs(i + d[0], j + d[1], threshold, visited);
        }

    }

    public int countingSteps(int limit, int rows, int cols, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || visited[r][c] || bitSum(r) + bitSum(c) > limit) return 0;
        visited[r][c] = true;
        return countingSteps(limit, rows, cols, r - 1, c, visited)
                + countingSteps(limit, rows, cols, r, c - 1, visited)
                + countingSteps(limit, rows, cols, r + 1, c, visited)
                + countingSteps(limit, rows, cols, r, c + 1, visited)
                + 1;
    }

    public int bitSum(int t) {
        int num = 0;
        while (t != 0) {
            num += t % 10;
            t /= 10;
        }
        return num;
    }

}
