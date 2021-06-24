package 剑指offer_0;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer
 * 04 重建二叉树[有先序遍历和中序遍历结果 构建二叉树]
 * 先序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，
 * 左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果
 *
 * @author xjh 2019.04.06
 */
public class 重建二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //编程实现1
    //map中缓存数组中每个值和其对应的索引
    private Map<Integer, Integer> indexInder = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexInder.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexInder.get(root.val);//得到根节点下标值
        int leftTreeSize = inIndex - inL;   //根节点的左子树范围
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    //编程实现2
    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree2(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree2(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                //前后切割 继续递归！
                root.left = reConstructBinaryTree2(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree2(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        return root;
    }
}
