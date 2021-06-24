package Tree;

/**
 * @author xjh 2019.05.21
 */
public class t101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recursive(root.left, root.right);
    }

    public boolean recursive(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return recursive(t1.right, t2.left) && recursive(t1.left, t2.right);
    }
}
