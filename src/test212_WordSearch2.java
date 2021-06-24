import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. Word Search II
 *
 * @author xjh 2018.12.28
 */
public class test212_WordSearch2 {
    public static List<String> list = new ArrayList<>();
    public static Set<String> set = new HashSet<>();

    public static List<String> findWords(char[][] board, String[] words) {

        //1.和leetcode 79一样利用dfs
        //思考：数组中的每一个string都要这样进行一次针对二位数组board的dfs遍历 假设word.length为k board为[n][m]大小的二维数组
//        for (int k=0;k<words.length;k++){
//            String word=words[k];
//            //79題的代码加进来
//            for (int i=0;i<board.length;i++){
//                for (int j=0;j<board[i].length;j++){
//                    if (dfs(board,i,j,word,0))
//                        set.add(word);
//                }
//            }
//        }

        //2.利用Trie树 将目标String[] 中的元素构建Trie树 然后利用dfs进行遍历
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);  //构建trie树
        }
        //进行dfs遍历
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, " ", i, j, trie);
            }
        }

        list.addAll(set);
        return list;
    }

    //方法1中的dfs
    public static boolean dfs(char[][] board, int i, int j, String word, int start) {
        //递归终止条件
        // 访问到数组边界
        if (i < 0 || i == board.length || j < 0 || j == board[i].length)
            return false;
        char c = board[i][j];
        //检查是否已经访问过
        if (c == '*') return false;
        if (c != word.charAt(start)) return false;    //不匹配
        if (start == word.length() - 1) return true;    //

        //dfs遍历过程
        board[i][j] = '*';    //标记为以访问
        boolean res = dfs(board, i + 1, j, word, start + 1) ||
                dfs(board, i - 1, j, word, start + 1) ||
                dfs(board, i, j + 1, word, start + 1) ||
                dfs(board, i, j - 1, word, start + 1);
        board[i][j] = c;  //还原 表示未被访问
        return res;
    }

    //方法2中的dfs
    public static void dfs(char[][] board, String str, int i, int j, Trie trie) {
        //递归终止条件
        // 访问到数组边界
        if (i < 0 || i == board.length || j < 0 || j == board[i].length)
            return;
        char c = board[i][j];
        //检查是否已经访问过
        if (c == '*') return;

        str += board[i][j];
        if (!trie.startsWith(str.substring(1))) return;  //如果前缀都不是，代表trie树中一定不会有这样的string出现
        if (trie.search(str.substring(1))) set.add(str.substring(1));

        //dfs遍历过程
        board[i][j] = '*';
        dfs(board, str, i + 1, j, trie);
        dfs(board, str, i - 1, j, trie);
        dfs(board, str, i, j - 1, trie);
        dfs(board, str, i, j + 1, trie);
        board[i][j] = c; //还原 表示未被访问
    }

    public static void main(String[] args) {
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        System.out.println(findWords(board, words));
    }
}
