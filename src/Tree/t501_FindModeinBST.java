package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 查找在BST中出现次数最多的节点值
 * 注意这里函数的返回值类型是int[] 可能有多个
 * 思路首先还是要中序遍历得到有序的数组，然后得到出现最多次数的值
 *
 * @author xjh 2019.05.29
 */
public class t501_FindModeinBST {
    public int cur = 1, max = 1;
    public TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        InOrder(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }

    public void InOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        InOrder(root.left, list);
        if (preNode != null) {
            if (preNode.val == root.val) cur++;
            else cur = 1;
        }
        if (cur > max) {
            max = cur;
            list.clear();   //原有的list元素清空
            list.add(root.val);
        } else if (cur == max) {
            list.add(root.val);
        }
        preNode = root;   //这个要写在当前层处理的最后
        InOrder(root.right, list);
    }
}
