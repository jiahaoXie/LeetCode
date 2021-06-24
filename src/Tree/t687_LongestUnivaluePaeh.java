package Tree;

/**
 * 题干的要求是在二叉树中具有相同值的节点的最长路径
 *
 * @author xjh 2019.05.22
 */
public class t687_LongestUnivaluePaeh {
    public static int count = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return count;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftLength = 0, rightLength = 0;
        if (root.left != null && root.left.val == root.val) leftLength = left + 1;
        if (root.right != null && root.right.val == root.val) rightLength = right + 1;
        count = Math.max(count, leftLength + rightLength);
        return Math.max(leftLength, rightLength);
    }
}
