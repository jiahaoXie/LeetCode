package 贝壳;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 动态规划和二分搜索
 */
public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        System.out.println(DPToBinarySearch(a));
    }

    public static int DPToBinary(int[] a) {
        int n = a.length;
        long[] dp = new long[n];
        int len = 0;
        for (long num : a) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {    //源码中返回 return -(low + 1);  // key not found.
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    /**
     * 这个dp加二分查找的方法容易理解一些
     *
     * @param nums
     * @return
     */
    public static int DPToBinarySearch(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /***** 搜索左侧边界的二分查找 *****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /*********************************/

            // 没找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }
}
