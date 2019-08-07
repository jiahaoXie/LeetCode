package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 查询二叉树中最后一行最左边的数值
 * @author xjh 2019.05.24
 * 这个题 一看就是一个层次遍历的题目 层次遍历通常需要借助一个队列来保存中间结果及输出顺序
 * 因为这里想要输出醉胡一行最左边节点的数值，根据队列先进先出的特征 这里每次投西安入队非叶子节点的右孩子 然后是左孩子
 */
public class t513_FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        TreeNode temp=null;
        while (!queue.isEmpty()){
            temp=queue.poll();
            if (temp.right!=null) queue.add(temp.right);
            if (temp.left!=null) queue.add(temp.left);
        }
        return temp.val;
    }
}
