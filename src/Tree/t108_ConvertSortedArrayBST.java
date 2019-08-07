package Tree;

/**
 * 有序数组中的元素转换为一颗平衡的BST
 * @author xjh 2019.05.26
 */
public class t108_ConvertSortedArrayBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        return BST(nums,0,nums.length-1);
    }
    public TreeNode BST(int[] nums,int start,int end){
        if (start>=end) return null;
        int mid=(start+end+1)>>1;   //这里括号里不加1 结果就不对
        TreeNode root=new TreeNode(nums[mid]);
        root.left=BST(nums,start,mid-1);
        root.right=BST(nums,mid+1,end);
        return root;
    }
}
