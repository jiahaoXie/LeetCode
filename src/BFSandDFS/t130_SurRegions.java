package BFSandDFS;

/**
 * leetcode 130. Surrounded Regions
 *
 * @author xjh 2019.03.19
 * 这是到很有意思的dfs的题目
 * 解题方法 我们采用逆向思维 dfs将处于数组边界的O以及与他相连的全都标记为T
 * 然后顺序数组 T的改为O 其他O改为X(因为他们被X包围了)
 */
public class t130_SurRegions {
    public int n, m;
    public int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};   //dfs遍历的四个方向

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        n = board.length;
        m = board[0].length;

        //首先处理边界及相邻的O
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);     //首列
            dfs(board, i, m - 1);   //尾列
        }
        for (int j = 0; j < m; j++) {
            dfs(board, 0, j); //首行
            dfs(board, n - 1, j);   //尾行
        }

        //顺序遍历数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'T') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    public void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m || board[row][col] != 'O') return; //递归终止条件
        board[row][col] = 'T';
        for (int[] d : direction) {
            dfs(board, row + d[0], col + d[1]);
        }
    }
}
