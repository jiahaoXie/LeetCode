package Tree;

/**
 * 球在一棵二叉树中给定两个节点的最近公共祖先
 *
 * @author xjh 2019.05.26
 */
public class t235_LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}