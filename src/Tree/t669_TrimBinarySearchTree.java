package Tree;

/**
 * 修剪二叉搜索树中的节点 使每个节点的只都在[L,R]内
 * DFS
 *
 * @author xjh 2019.05.25
 */
public class t669_TrimBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
