package Tree;

/**
 * 在一棵二叉树中不相邻节点之间的最大值之和
 * 分两种情况： 包含根节点 和不包含根节点
 *
 * @author xjh 2019.05.23
 */
public class t337_HouseRobberIII {

    //方法1 样例没通过 [4,1,null,2,null,3]正确输出是7 代码输出为6
    public int rob2(TreeNode root) {
        boolean flag = true;  //设置标志位
        int num1 = dfs(root, flag);
        if (root == null) return 0;
        int num2 = dfs(root.left, flag) + dfs(root.right, flag);
        return Math.max(num1, num2);
    }

    public int dfs(TreeNode root, boolean flag) {
        if (root == null) return 0; //递归终止条件
        int temp = 0;
        if (flag) {
            temp += root.val;
            flag = false;
        } else flag = true;
        temp += dfs(root.left, flag);
        temp += dfs(root.right, flag);
        return temp;
    }

    //方法2
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int val1 = root.val;
        if (root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) val1 += rob(root.right.left) + rob(root.right.right);
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }

    //方法3 最容易理解的一个版本
    public int rob3(TreeNode root) {
        return Math.max(robInRoot(root), robExRoot(root));
    }

    public int robInRoot(TreeNode root) {
        if (root == null) return 0;
        return root.val + robExRoot(root.left) + robExRoot(root.right);
    }

    public int robExRoot(TreeNode root) {
        if (root == null) return 0;
        return rob3(root.left) + rob3(root.right);
    }

    public static void main(String[] args) {
        t337_HouseRobberIII xjh = new t337_HouseRobberIII();
        int[] test = {4, 1, 0, 2, 0, 3};

        TreeNode root = xjh.createTree(test, 0);
        System.out.println(xjh.rob(root));
    }

    //由一维数组元素构建普通二叉树
    public TreeNode createTree(int[] test, int start) {
        if (test[start] == 0) return null;
        TreeNode root = new TreeNode(test[start]);
        int lnode = 2 * start + 1;
        int rnode = 2 * start + 2;
        if (lnode >= test.length) root.left = null;
        else root.left = createTree(test, lnode);

        if (rnode >= test.length) root.right = null;
        else root.right = createTree(test, rnode);

        return root;
    }

}
