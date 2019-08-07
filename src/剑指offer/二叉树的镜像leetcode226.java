package 剑指offer;

/**
 * leetcode 226 Invert Binary Tree
 * @author xjh 2019.04.09
 */
public class 二叉树的镜像leetcode226 {
    //代码1
    public void Mirror0(TreeNode root) {
        if (root==null) return;
        mirror(root);
    }
    public TreeNode mirror(TreeNode root){
        TreeNode left=root.left;
        root.left=mirror(root.right);
        root.right=mirror(left);
        return root;
    }

    public TreeNode Mirror2(TreeNode root) {
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        Mirror2(root.left);
        Mirror2(root.right);
        return root;
    }
}
