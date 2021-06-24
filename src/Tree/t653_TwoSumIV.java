package Tree;

import java.util.ArrayList;

/**
 * 输入是一颗二叉搜索树，是否能找找到树中两个结点的值等于给定值
 *
 * @author xjh 2019.05.29
 * 思路： 首先，中序遍历得到升序数组.然后，首尾双指针法查找
 */
public class t653_TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        ArrayList<Integer> list = new ArrayList<>();
        InOrder(root, list);
        for (int i = 0, j = list.size() - 1; i < j; ) {
            int temp = list.get(i) + list.get(j);
            if (temp == k) return true;
            else if (temp > k) j--;
            else i++;
        }
        return false;
    }

    public void InOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        InOrder(root.left, list);
        list.add(root.val);
        InOrder(root.right, list);
    }
}
