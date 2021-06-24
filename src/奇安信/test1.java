package 奇安信;

import java.util.Scanner;

/**
 * 查找BST上两个节点的最近公共祖先
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        String[] ss = str.split(" ");
        TreeNode[] node = new TreeNode[ss.length];
        for (int i = 0; i < ss.length; i++) {
            node[i] = new TreeNode(Integer.valueOf(ss[i]));
        }
        for (int i = 0; i < n - 1; i++) {
            node[i].left = node[2 * i + 1];
            node[i].right = node[2 * i + 2];
        }
        int p = in.nextInt(), q = in.nextInt();
        if ((find(node, p) && find(node, q)) == false) {
            System.out.println(-1);
            return;
        }
        TreeNode t = lowestCommonAncestor(node[0], p, q);
        if (t == null) System.out.println(-1);
        else System.out.println(t.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root.val == -1) return null;
        if (root.val < p && root.val < q) return lowestCommonAncestor(root.right, p, q);
        else if (root.val > p && root.val > q) return lowestCommonAncestor(root.left, p, q);
        return root;
    }

    public static boolean find(TreeNode[] nodes, int t) {
        boolean flag = false;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].val == t) flag = true;
        }
        return flag;
    }
}
