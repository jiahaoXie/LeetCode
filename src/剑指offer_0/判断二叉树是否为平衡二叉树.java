package 剑指offer_0;

/**
 * leetcode 110题
 *
 * @author xjh 2019.04.18
 */
public class 判断二叉树是否为平衡二叉树 {
    private boolean result = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        if (Math.abs(lDepth - rDepth) > 1) result = false;
        return 1 + Math.max(lDepth, rDepth);
    }
}
