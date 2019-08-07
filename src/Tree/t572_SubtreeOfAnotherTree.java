package Tree;

/**
 * DFS 和437思路相似
 * @author xjh 2019.05.21
 */
public class t572_SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null||t==null) return false;
        return isSubtreeWithRoot(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
    }

    public boolean isSubtreeWithRoot(TreeNode s,TreeNode t){
        if (s==null&&t==null) return true;
        if (s==null||t==null) return false;
        if (s.val!=t.val) return false;
        return isSubtreeWithRoot(s.left,t.left)&&isSubtreeWithRoot(s.right,t.right);
    }
}
