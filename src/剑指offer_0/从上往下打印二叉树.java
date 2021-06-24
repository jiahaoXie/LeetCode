package 剑指offer_0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树—层次遍历或者说是BFS
 *
 * @author xjh 2019.04.10
 */
public class 从上往下打印二叉树 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();   //辅助队列
        queue.add(root);
        while (!queue.isEmpty()) {
//            int size=queue.size();
//            while (size-->0){
            TreeNode temp = queue.poll();
            res.add(temp.val);
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
//            }
        }
        return res;
    }
}
