package Tree;

/**
 * leetcode 98 验证二叉搜索树BST
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class test98_验证二叉搜索树BST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true; //树为空 默认为BST
        //方法1.利用BST的性质 左子树<根节点<右子树 非中序遍历的方法
//        return helper(root,Long.MIN_VALUE, Long.MAX_VALUE);
        //方法2.利用中序遍历得到值为升序数组 来及逆行判断
        List<Integer> list = new ArrayList<>();   //新建一个list用来存储中序遍历得到的值
        InOrder(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) return false;
        }
        return true;
    }

    public boolean helper(TreeNode root, long minVal, long maxVal) {
        if ((root.val <= minVal) || (root.val >= maxVal))   //BST必须满足左<根<右
            return false;
        return helper(root.left, minVal, root.val) && helper(root.right, root.val, maxVal);
        //递归判断左 根 右的值大小
    }

    //中序遍历
    public void InOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        InOrder(root.left, list);
        list.add(root.val);
        InOrder(root.right, list);
    }
}
