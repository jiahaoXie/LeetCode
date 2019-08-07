package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 102 Binary Tree Level Order Traversal
 * @author xjh 2018.12.11
 */
public class test102_BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
     //1.利用层次遍历 或者说BFS 逐层遍历输出
//        List<List<Integer>> list = new ArrayList<>();
//        if(root==null)return list;
//        List<TreeNode> nl = new ArrayList<>();    //网上的答案是借助一个辅助数组
//        nl.add(root);   //根节点入数组
//        sync(list,new ArrayList(),nl);
//        return list;

        //2.利用DFS进行解决
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,root,0);
        return res;

    }
    public void sync(List<List<Integer>> list,List<Integer> il,  List<TreeNode> tl){
        if(tl.size()==0)return;
        List<TreeNode> snl = new ArrayList();
        for(TreeNode t:tl){
            il.add(t.val);      //保存节点的值
            if(t.left!=null)
                snl.add(t.left);    //入数组
            if(t.right!=null)
                snl.add(t.right);
        }
        list.add(il);
        sync(list,new ArrayList(),snl); //递归操作
    }
    public void dfs(List<List<Integer>> res, TreeNode root,int height){
        if(root==null) return;
        if(height>=res.size()){
            //初始时res.size()为0 创建一个空的链表用于存储第一层信息
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        dfs(res,root.left,height+1);
        dfs(res,root.right,height+1);
    }

    public static void main(String[] args) {
        List<List<Integer>> res=new ArrayList<>();
        System.out.println(res.size());
    }
}
