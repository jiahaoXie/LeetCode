package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 78 Subsets
 * leetcode 90 Subsets II
 *
 * @author xjh 2019.03.28
 */
public class t78_Subsets {
    public static void main(String[] args) {
        t78_Subsets xjh = new t78_Subsets();
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = xjh.subsetsWithDup2(nums);
        for (List<Integer> temp : res)
            System.out.println(temp);
    }

    //78题
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {   //for循环是这个程序最妙的地方
            backtracking(0, res, temp, i, nums);
        }
        return res;
    }

    public void backtracking(int start, List<List<Integer>> res, List<Integer> temp, int size, int[] nums) {
        if (temp.size() == size) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(i + 1, res, temp, size, nums);
            //回溯
            temp.remove(temp.size() - 1);
        }
    }

    //90题方法1 参考78题思路 稍加修改 运行时间15ms 快于5.55%的代码
    //速度慢的原因是因为 代码中啊hi是穷举了所有的情况 知识对结果进行了剪枝
    // 更优的方法是 在回溯过程中剪枝 利用visited数组
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);  ////这段代码出现在90题
        for (int i = 0; i <= nums.length; i++) {   //for循环是这个程序最妙的地方
            backtracking2(0, res, temp, i, nums);
        }
        return res;
    }

    public void backtracking2(int start, List<List<Integer>> res, List<Integer> temp, int size, int[] nums) {
        if (temp.size() == size) {
            if (!res.contains(temp))
                res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(i + 1, res, temp, size, nums);
            //回溯
            temp.remove(temp.size() - 1);
        }
    }

    //90题方法2 利用visited数组对回溯过程进行剪枝
    //运行时间1ms 快于100%的代码
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);  ////这段代码出现在90题
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i <= nums.length; i++) {   //for循环是这个程序最妙的地方
            backtracking3(0, res, temp, i, nums, visited);
        }
        return res;
    }

    public void backtracking3(int start, List<List<Integer>> res, List<Integer> temp, int size, int[] nums, boolean[] visited) {
        if (temp.size() == size) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;  //i!=0主要是防止程序 下标异常报错)
            visited[i] = true;
            temp.add(nums[i]);
            backtracking3(i + 1, res, temp, size, nums, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
