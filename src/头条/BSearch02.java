package 头条;

/**
 * 旋转数组中查找指定值 字节跳动暑期实习二面第二道题（也是leetcode 33题）
    * 例如：递增数组[1,2,3,4,5]，变化为[5,6,1,2,3,4]， 给定K，判断是否存在，并返回其索引位置
 * @author xjh 2019.03.23
 * 思路：这是一道需要技巧的二分查找  难！！
 * 1.a[mid]>a[low] mid左边的数组是有序的；接着判断 当k<a[mid] && k>=a[low] ,可以在左边数组查找，否则在右边数组中查找
 * 2.a[mid] <a[high] mid右边数组是有序的; 接着判断 k > a[middle] && k <= a[high] , 可以在右边数组查找，否则在左边数组查找
 */
public class BSearch02 {
    public static void main(String[] args) {
        BSearch02 xjh=new BSearch02();
        int[] a={7,9,12,15,0,3,5,6};
        int[] b={3,1};
        System.out.println(xjh.findK2(b,1));
    }

    //奇怪的是，这里有样例通过不了
    public int findK(int[] a,int k){
        int begin=0;
        int end=a.length-1;
        while (begin<=end){
            int mid=begin+(end-begin)/2;
            if (k==a[mid]) return mid;
            if (a[mid]>a[begin]){//mid左边是有序的
                if (k>=a[begin]&&k<a[mid]) end=mid-1;
                else begin=mid+1;
            }else {//后半部分 是递增数组
                if (k>a[mid]&&k<=a[end]) begin=mid+1;
                else end=mid-1;
            }
        }
        return -1;
    }

    //网上大佬的答案
    public int findK2(int[] num,int k){
        int begin=0,end=num.length-1;
        while (begin<end){
            int mid=begin+(end-begin)/2;
            if (num[0]>k^(num[0]>num[mid])^(k>num[mid])) begin=mid+1;
            else end=mid;
        }
        return begin==end&&num[begin]==k?begin:-1;
    }
    /**
     * 以二分搜索为基本思路
     简要来说：
     nums[0] <= nums[mid]（0 - mid不包含旋转）且nums[0] <= target <= nums[mid] 时 high 向前规约；
     nums[mid] < nums[0]（0 - mid包含旋转），target <= nums[mid] < nums[0] 时向前规约（target 在旋转位置到 mid 之间）
     nums[mid] < nums[0]，nums[mid] < nums[0] <= target 时向前规约（target 在 0 到旋转位置之间）

     其他情况向后规约
     也就是说nums[mid] < nums[0]，nums[0] > target，target > nums[mid] 三项均为真或者只有一项为真时向后规约。

     原文的分析是：
     注意到原数组为有限制的有序数组（除了在某个点会突然下降外均为升序数组）
     if nums[0] <= nums[I] 那么 nums[0] 到 nums[i] 为有序数组,那么当 nums[0] <= target <= nums[i] 时我们应该在 0-i0−i 范围内查找；
     if nums[i] < nums[0] 那么在 0-i0−i 区间的某个点处发生了下降（旋转），那么 I+1I+1 到最后一个数字的区间为有序数组，并且所有的数字都是小于 nums[0] 且大于 nums[i]，当target不属于 nums[0] 到 nums[i] 时（target <= nums[i] < nums[0] or nums[i] < nums[0] <= target），我们应该在 0-i0−i 区间内查找。

     上述三种情况可以总结如下：
     nums[0] <= target <= nums[i]
     target <= nums[i] < nums[0]
     nums[i] < nums[0] <= target
     所以我们进行三项判断：
     (nums[0] <= target)，(target <= nums[i]) ，(nums[i] < nums[0])，现在我们想知道这三项中有哪两项为真（明显这三项不可能均为真或均为假（因为这三项可能已经包含了所有情况））
     所以我们现在只需要区别出这三项中有两项为真还是只有一项为真。
     使用 “异或” 操作可以轻松的得到上述结果（两项为真时异或结果为假，一项为真时异或结果为真，可以画真值表进行验证）
     之后我们通过二分查找不断做小 target 可能位于的区间直到 low==high，此时如果 nums[low]==target 则找到了，如果不等则说明该数组里没有此项。
     */
}
