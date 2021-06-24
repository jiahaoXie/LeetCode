package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 257 Binary Tree Paths
 *
 * @author xjh 2019.03.25
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class t257_BTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        List<Integer> values = new ArrayList<>();
        backtracking(root, values, paths);
        return paths;
    }

    public void backtracking(TreeNode root, List<Integer> values, List<String> paths) {
        if (root == null) return;
        values.add(root.val);
        if (root.left == null && root.right == null) paths.add(buildPath(values));
        else {//非叶子节点 递归遍历
            backtracking(root.left, values, paths);
            backtracking(root.right, values, paths);
        }
        values.remove(values.size() - 1); //回溯 删除当前位置的元素
    }

    public String buildPath(List<Integer> values) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            str.append(values.get(i));
            if (i != values.size() - 1) str.append("->");
        }
        return str.toString();
    }
}
