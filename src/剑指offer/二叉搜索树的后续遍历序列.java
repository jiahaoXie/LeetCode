package 剑指offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * @author xjh 2019.04.10
 * 这道题 有点难度 需要一点技巧【反复看！！！】
 * 因为BST（左<根<右） 后序遍历(左右根)
 * 对于合法数组 最后一个元素x是二叉树的根节点，去掉最后一个根节点后的数组可分为两个部分
 * 前一部分是根节点的左子树都小于x 后一部分是右子树 都大于x
 * 分片之后 重复相同操作，递归解决
 */

public class 二叉搜索树的后续遍历序列 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0) return false;
        return judge(sequence,0,sequence.length-1);
    }
    public static boolean judge(int[] a,int low,int high){
        if (low>=high) return true;
        int i=high;
        while (i>low&&a[i-1]>a[high]) { //从后往前遍历 右子树的节点值 都比根节点大
            i--;  //结束循环时 i是根节点右子树的最下层的左叶子节点
        }

        for (int j=low;j<=i-1;j++){
            //从前往后遍历 左子树的所有节点 都应该比根节点值 小
            if (a[j]>a[high]) return false;
        }
        return judge(a,low,i-1)&&judge(a,i,high-1);
        //去除根节点 数组切割为两部分 递归操作
    }

    public static void main(String[] args) {
        int[] sequence={4,8,6,12,16,14,10};
        System.out.println(VerifySquenceOfBST(sequence));
    }
}
