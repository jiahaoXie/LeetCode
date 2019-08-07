package 剑指offer;

/**
 * 输入一颗二叉搜索树，将其转换成为一个排序的双向链表。
 * @author xjh 2019.04.12
 * BST中序遍历得到一个升序的序列
 */
public class 二叉搜索树与双向链表 {
    private TreeNode currentNode=null;
    private TreeNode head=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null) return null;
        inOrder(pRootOfTree);
        return head;
    }

    public void inOrder(TreeNode root){
        if (root==null) return;    //递归终止条件
        inOrder(root.left);
        if (currentNode==null){ //双向链表的头指针
            currentNode=root;
            head=root;
        }else { //构建双向链表
            currentNode.right=root;
            root.left=currentNode;
            currentNode=root;
        }
        inOrder(root.right);
    }

}
