package Tree;

/**
 * leetcode 543 计算两个树节点之间的最大长度
 * @author xjh 2019.05.19
 * 这依旧是一个求树高度 衍生出来的题目
 */

public class t543_DiameterOfBinaryTree {
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R);
        return Math.max(L, R) + 1;
    }

}
