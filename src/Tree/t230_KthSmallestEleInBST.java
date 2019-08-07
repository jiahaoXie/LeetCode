package Tree;

/**
 * 查找二叉搜索树中的第k小元素
 * @author xjh 2019.05.25
 * 中序得到升序的数组值，取第k-1个
 */
public class t230_KthSmallestEleInBST {
    int cnt=0,res;
    public int kthSmallest(TreeNode root, int k) {
        InOrder(root,k);
        return res;
    }
    public void InOrder(TreeNode root,int k){
        if (root==null) return;

        InOrder(root.left,k);
        cnt++;
        if (cnt==k){
            res=root.val;
            return;
        }
        InOrder(root.right,k);
    }
}
