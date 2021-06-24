import java.util.HashSet;

/**
 * leetcode 36 Valid Sudoku
 * leetcode 37. Sudoku Solver
 *
 * @author xjh 2018.12.24
 */
public class t36And37数独 {
    //2.leetcode 36 采用简洁的方法 利用HashSet  直接判断该位置 是否有效
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                //依次检查对应的行 列 小的九宫格 是否有相同元素冲突： 该位置已经有元素并且对应的set中填入了该数值
                // 检查第i行，在横坐标位置
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    //这里!row.add(x) 判断用的很巧妙 因为set不能包含重复的元素 所以原有的元素就无法添加成功
                    return false;
                // 检查第i列，在纵坐标位置
                if (board[j][i] != '.' && !column.add(board[j][i]))
                    return false;
                /**
                 * 难点在于表示第i个九宫格每个格点的坐标。
                 观察行号规律：
                 第0个九宫格：000111222; 第1个九宫格：000111222; 第2个九宫格：000111222;
                 第3个九宫格：333444555; 第4个九宫格：333444555; 第5个九宫格：333444555;
                 第6个九宫格：666777888; 第7个九宫格：666777888; 第8个九宫格：666777888;
                 可见对于每三个九宫格行号增3；对于单个九宫格，每三个格点行号增1。
                 因此第i个九宫格的第j个格点的行号可表示为i/3*3+j/3（每个小九宫格j都是从0~9递增）

                 观察列号规律：
                 第0个九宫格：012012012; 第1个九宫格：345345345; 第2个九宫格：678678678;
                 第3个九宫格：012012012; 第4个九宫格：345345345; 第5个九宫格：678678678;
                 第6个九宫格：012012012; 第7个九宫格：345345345; 第8个九宫格：678678678;
                 可见对于下个九宫格列号增3，循环周期为3；对于单个九宫格，每个格点行号增1，周期也为3。
                 周期的数学表示就是取模运算mod。
                 因此第i个九宫格的第j个格点的列号可表示为i%3*3+j%3（每个小九宫格j都是从0~9递增）
                 */
                // 行号+偏移量
                int RowIndex = 3 * (i / 3) + j / 3;
                // 列号+偏移量
                int ColIndex = 3 * (i % 3) + j % 3;
                //每个小九宫格，总共9个
                if (board[RowIndex][ColIndex] != '.'
                        && !cube.add(board[RowIndex][ColIndex]))
                    return false;
            }
        }
        return true;
    }

    //第一种方法 采用递归的方法解决 37题填入通过
    public void solveSudoku(char[][] board) {
        //返回值是true or false
        if (board.length == 0) return;
        Input(board);
    }

    public boolean Input(char[][] board) {
        //依次往二维数组中的空格输入字符
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    //当前位置为空字符
                    for (char c = '1'; c <= '9'; c++) {
                        if (IsValid(board, i, j, c)) {
                            //用于判断是否在当前位置有效 有效则填入该字符
                            board[i][j] = c;
                            if (Input(board)) return true;
                            else board[i][j] = '.';   //否则回溯 之前位置的字符重新填写
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    //判断输入是否合法
    public boolean IsValid(char[][] board, int i, int j, char c) {
        for (int k = 0; k < board.length; k++) {
            if (board[i][k] != '.' && board[i][k] == c) return false; //同列
            if (board[k][j] != '.' && board[k][j] == c) return false; //同行
            //3X3的九宫格内
            if (board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] != '.' && board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == c)
                return false;
        }
        return true;
    }


}
