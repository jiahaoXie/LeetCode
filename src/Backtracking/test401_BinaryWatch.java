package Backtracking;

import java.util.*;

/**
 * leetcode 401 BinaryWatch
 * @author xjh  2019.01.08
 */
public class test401_BinaryWatch {
    public static List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[]{8, 4, 2, 1}, nums2 = new int[]{32, 16, 8, 4, 2, 1};
        for(int i = 0; i <= num; i++) {
            List<Integer> list1 = generateDigit(nums1, i);
            List<Integer> list2 = generateDigit(nums2, num - i);
            for(int num1: list1) {
                if(num1 >= 12) continue;
                for(int num2: list2) {
                    if(num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }
    private static List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }

    private static void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        //递归终止条件 表示灯全部亮完
        if(count == 0) {
            res.add(sum);
            return;
        }
        //下面这个for设计的很巧妙 是回溯算法的精髓 (回溯算法说白了就是枚举所有可能发生的情况 遇到终止条件后后退回去虚招别的路)
        for(int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        List<String> list=readBinaryWatch(n);
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}
