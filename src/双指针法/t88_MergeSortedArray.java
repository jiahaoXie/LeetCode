package 双指针法;

/**
 * leetcode 88 Merge Sorted Array
 *
 * @author xjh 2019.02.22
 */
public class t88_MergeSortedArray {
    /**
     * 方法1 ：建立临时数组 存储结果 两个有序数组从前往后进行比较
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[nums1.length];    //创建一个临时数组 存放合并结果
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) res[k++] = nums1[i++];
            else res[k++] = nums2[j++];
        }
        //剩余的数 直接存入数组中
        while (i < m) {
            res[k++] = nums1[i++];
        }
        while (j < n) {
            res[k++] = nums2[j++];
        }

        i = 0;
        k = 0;
        while (i < res.length) nums1[i++] = res[k++];
    }

    /**
     * 方法2 ：无需额外的数组 两个数组从后往前比较【这里不能从前向后比较，因为会覆盖没有比较的值】
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        merge(num1, 3, num2, 3);
        for (int i = 0; i < num1.length; i++)
            System.out.print(num1[i] + " ");
        System.out.println();
    }
}
