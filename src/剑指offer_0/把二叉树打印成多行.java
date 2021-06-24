package 剑指offer_0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xjh 2019.04.30
 */
public class 把二叉树打印成多行 {
    //方法1 linkedlist 上一题代码简要修改
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) {
            return ret;
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(null);//层分隔符
        queue.addLast(pRoot);

        while (queue.size() != 1) {
            TreeNode node = queue.removeFirst();
            if (node == null) {//到达层分隔符
                Iterator<TreeNode> iter = null;
                iter = queue.iterator();//从前往后遍历

                while (iter.hasNext()) {
                    TreeNode temp = (TreeNode) iter.next();
                    list.add(temp.val);
                }
                ret.add(new ArrayList<Integer>(list));
                list.clear();
                queue.addLast(null);//添加层分隔符
                continue;//一定要continue
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return ret;
    }

    ArrayList<ArrayList<Integer>> Print3(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();    //中间list 用于存储每行的节点
        layer.add(pRoot);
        int start = 0, end = 1;
        while (!layer.isEmpty()) {
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
            start++;
            if (cur.left != null) {
                layer.add(cur.left);
            }
            if (cur.right != null) {
                layer.add(cur.right);
            }
            if (start == end) {
                end = layer.size(); //end记录下一层结点个数 因为上一层的已经移除了
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<Integer>();
            }
        }
        return result;
    }


    //方法2 递归实现
    ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if (root == null) return;
        if (depth > list.size())
            list.add(new ArrayList<Integer>());
        list.get(depth - 1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }
}
