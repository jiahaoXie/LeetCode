package 快手2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 判断一颗满二叉树是是否为二叉搜索树
 */
public class test02 {
    public static class BinaryTreeNode {
        private int data;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode(String t) {
            char[] temp = t.toCharArray();
            data = temp[0] - '0';
        }
    }

    // 根据数组创建完全二叉树
    private static BinaryTreeNode createTree(String[] arr) {
//        if(arr.length==1)
//            return new BinaryTreeNode(arr[0]);
        List<BinaryTreeNode> nodeList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            nodeList.add(new BinaryTreeNode(arr[i]));
        for (int i = 1; i <= arr.length / 2; i++) {
            if (2 * i - 1 <= arr.length - 1)
                nodeList.get(i - 1).left = nodeList.get(2 * i - 1);
            if (2 * i <= arr.length - 1)
                nodeList.get(i - 1).right = nodeList.get(2 * i);
        }
        return nodeList.get(0);
    }

    static BinaryTreeNode root = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if (s == "None") {
            System.out.println("True");
            return;
        }
        //s不为空 转化为二叉树
        String[] temp = s.split(",");
        root = createTree(temp);   //建树
        int[] res = new int[temp.length];
        for (int i : res)
            System.out.print(i + " ");
        System.out.println();
        inOrder(root, res);  //中序遍历得到 数组值
        for (int i : res)
            System.out.print(i + " ");
        System.out.println();
        //数组是否为升序
        boolean flag = false;
        for (int i = 0; i < res.length - 1; i++) {
            if (res[i] != Math.min(res[i], res[i + 1])) {
                flag = false;
                break;
            }
        }
        if (flag) System.out.println("True");
        else System.out.println("False");
    }

    public static void inOrder(BinaryTreeNode root, int[] res) {
        if (root.left != null) inOrder(root.left, res);
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) {
                res[i] = root.data;
                break;
            }
        }
        if (root.right != null) inOrder(root.right, res);
    }
}
