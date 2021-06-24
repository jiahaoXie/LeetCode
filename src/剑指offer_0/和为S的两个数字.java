package 剑指offer_0;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * @author xjh 2019.04.22
 * 很明显的一道双指针的题目
 */
public class 和为S的两个数字 {
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        //因为这里的输出是一个ArrayList 输出两个数 小的先输出
        //所以这里定义一个ArrayList<ArrayList<Integer>>保存所有结果
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int temp = array[low] + array[high];
            if (temp == sum) {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(array[low]);
                t.add(array[high]);
                res.add(t);
                low++;
            } else if (temp < sum) low++;
            else high--;
        }
        if (res.size() == 0) return new ArrayList<>();
        else return res.get(0);
    }

    public static void main(String[] args) {
        int sum = 15;
        int[] a = {1, 2, 4, 7, 11, 15};
        ArrayList<Integer> result = FindNumbersWithSum(a, sum);
        System.out.println(result);
    }
}
