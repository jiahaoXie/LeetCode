package Tree;

/**
 * 一棵二叉树中节点要么没有叶子节点 要么有两个叶子节点，非叶子节点是叶子节点的较小值
 * 求二叉树中第二次小的节点。【如果二叉树非空 这个场景中根节点就是最小节点】
 * @author xjh 2019.05.23
 */
public class t671_SecondMinNode {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return -1;
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
        if (rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
        //当leftVal和rightVal都不为-1时 求二者最小值；否则就是 不为-1的那个值
        if (leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
        if (leftVal != -1) return leftVal;
        return rightVal;
    }
}
