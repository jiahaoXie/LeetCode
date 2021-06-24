package BFSandDFS;

/**
 * leetcode 79 Word Search
 *
 * @author xjh 2019.03.25
 * dfs解题
 */
public class t79_WordSearch {
    public int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        t79_WordSearch xjh = new t79_WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String s = "ABCCED";
        System.out.println(xjh.exist(board, s));
    }

    public boolean exist(char[][] board, String word) {
        //处理边界条件
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        boolean res = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(0, board, i, j, word, visited)) {
                    res = true;
                }
            }
        }
        return res;
    }

    public boolean dfs(int cur, char[][] board, int i, int j, String word, boolean[][] visited) {
        if (cur == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(cur))
            return false;
        visited[i][j] = true;
        for (int[] d : direction) {
            if (dfs(cur + 1, board, i + d[0], j + d[1], word, visited)) return true;
        }
        visited[i][j] = false;
        return false;
    }

}
