package Tree;

/**
 * leetcode 236 Lowest Common Ancestor of a Binary Tree
 * @author xjh 2018.12.03
 */

public class t236_LowestComAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 这里采用递归的方法 查找最近公共祖先
     * 时间复杂度事O(n)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p||root==q) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);  //递归其左子树
        TreeNode right=lowestCommonAncestor(root.right,p,q);    //递归右子树
        if(left==null) return right;
        else if(right==null) return right;
        else return root;
    }
}
