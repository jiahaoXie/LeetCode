package Tree;

/**
 * leetcode 111 Minimum Depth of Binary Tree
 * leetcode 104. Maximum Depth of Binary Tree
 *
 * @author xjh 2018.12.17
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class test111_MaxAndMinDepth {
    public int minDepth(TreeNode root) {
        //在求二叉树的最小深度时，需要考虑根节点 和左右子节点是否为空的情况
        //因为如果存在左节点（或右节点） 为空时，变为单一指向
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        int result = 1 + Math.min(leftDepth, rightDepth);
        return result;
    }

    public int maxDepth(TreeNode root) {
        //求二叉树的最大深度 只需要考虑根节点是否为空
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
