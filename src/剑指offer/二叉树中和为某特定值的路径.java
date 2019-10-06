package 剑指offer;

import java.util.ArrayList;
/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 * 题干中 要求返回值的所有list中 数组长度大的数组靠前，这个意思应该是需要对res中每个数据根据res.get(i)的size大小 进行降序排序
 * 但是 ac的代码中并没有执行这方面功能 也ac了
 * 经典的回溯算法题！！！ 【常看】
 * @author xjh 2019.04.11
 */
public class 二叉树中和为某特定值的路径 {
    private ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    private ArrayList<Integer> temp=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null) return res;
        temp.add(root.val);
        target-=root.val;
        if (target==0&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(temp)); //这里不能写为res.add(temp) 测试为0
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        temp.remove(temp.size()-1); //回溯 作用等同于标记为未访问
        return res;
    }
}
