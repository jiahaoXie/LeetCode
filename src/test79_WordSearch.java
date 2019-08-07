/**
 * 79. Word Search
 * @author xjh 2018.12.28
 */
public class test79_WordSearch {
    public boolean exist(char[][] board, String word) {
        // 这个题的思路是利用DFS
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if (dfs(board,i,j,word,0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,int i,int j,String word,int start){
        //递归终止条件
        // 访问到数组边界
        if (i<0||i==board.length||j<0||j==board[i].length)
            return false;
        char c=board[i][j];
        //检查是否已经访问过
        if (c=='*') return false;
        if (c!=word.charAt(start)) return false;    //不匹配
        if (start==word.length()-1) return true;    //

        //dfs遍历过程
        board[i][j]='*';    //标记为以访问
        boolean res=dfs(board,i+1,j,word,start+1)||
                dfs(board,i-1,j,word,start+1)||
                dfs(board,i,j+1,word,start+1)||
                dfs(board,i,j-1,word,start+1);
        board[i][j]=c;  //还原
        return res;
    }
}
