package Tree;

/**
 * @author xjh 2019.05.20
 */
public class t437PathSumIII {
    //方法1 暴力破解 DFS
    // 运行时间11ms 快于58.88%
    public static int count=0;
    public int pathSum(TreeNode root, int sum) {
        if (root==null) return 0;
        count=startWithRoot(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
        return count;
    }
    public int startWithRoot(TreeNode root,int sum){
        if (root==null) return 0;   //递归终止条件
        int temp=0;
        if (root.val==sum) temp++;
        //因为节点的数值可以是 负数 所以即便当前遍历节点的值大于sum 也可以继续遍历下去
        temp+=startWithRoot(root.left,sum-root.val)+startWithRoot(root.right,sum-root.val);
        return temp;
    }
}
