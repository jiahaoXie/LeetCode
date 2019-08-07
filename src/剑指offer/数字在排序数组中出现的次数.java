package 剑指offer;

/**
 * 这里考察的主要是时间复杂度的优化
 * @author xjh 2019.04.17
 */
public class 数字在排序数组中出现的次数 {
    public static int GetNumberOfK(int [] array , int k) {
        if (array.length==0||k<array[0]||k>array[array.length-1]) return 0;
        int count=0;
        //方法1 一层for循环 时间复杂度是O(n)
//        for (int i=0;i<array.length;i++){
//            if (array[i]==k) count++;
//        }

        //方法2 考虑到是有序数组 可用二分查找 时间复杂度是O(logn)
        int first=search(array,k); //查找等于给定值的首下标
        int last=search(array,k+1)-1;
        return last-first+1;
    }
    public static int search(int[] nums,int k){
        int l=0,n=nums.length;  //这里n初始值不能写成nums.length-1
        while (l<n){
            int mid=l+(n-l)/2;
            if (nums[mid]>=k) n=mid;
            else l=mid+1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        System.out.println(GetNumberOfK(nums,9));
    }
}
