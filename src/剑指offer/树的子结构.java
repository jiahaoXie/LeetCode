package 剑指offer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author xjh 2019.04.08
 * 这道题有点难度，很经典！
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class 树的子结构 {
    //方法1 网上的答案 大佬 递归玩的极强
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1==null||root2==null) return false;
        boolean flag;
        return isSubTree(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
        //其实这句话就是先序遍历的思路（根左右）
    }
    public boolean isSubTree(TreeNode root1,TreeNode root2){
        if (root2==null) return true;   //这里判断为true是因为递归遍历到这里 root2的节点已经匹配完了，说明是子结构关系
        if (root1==null) return false;  //同理，root1为null 说明不是包含关系 返回false
        if (root1.val==root2.val){
            return isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right);
        }else return false;
    }
}


