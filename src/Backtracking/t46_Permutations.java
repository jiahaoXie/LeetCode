package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列问题
 * leetcode 46 Permutations 经典的全排列问题【回溯算法来解决】
 * leetcode 47 Permutations II 含重复元素的全排列问题
 * 47题中因为数组中有相同元素 在进行排列时会出现重复的排列 因而选哟相办法去除这些重复的排列组合方式
 * 此方法运行时间 快于100%的代码
 * @author xjh 2019.03.25
 */
public class t46_Permutations {
    public static void main(String[] args) {
        t46_Permutations xjh=new t46_Permutations();
        int[] nums={1,2,3};
        List<List<Integer>> res=xjh.permute(nums);
        for (List<Integer> temp:res)
            System.out.print(temp);
        System.out.println();
    }
    //46题
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(res,temp,nums,visited);
        return res;
    }
    public void backtracking(List<List<Integer>> res,List<Integer> temp,int[] nums,boolean[] visited){
        if (temp.size()==nums.length){
            //递归终止条件
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=0;i<visited.length;i++){
            if (visited[i]) continue;
            visited[i]=true;
            temp.add(nums[i]);
            backtracking(res,temp,nums,visited);
            //回溯
           temp.remove(temp.size()-1);
            visited[i]=false;
        }
    }

    //47 题 因为含有相同元素 所以先要进行排序
    //在递归过程中 添加一个元素时，判断这个元素是否等于前一个元素，如果等于，并且前一个元素还未访问，那么就跳过这个元素。
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtracking2(res,temp,nums,visited);
        return res;
    }
    public void backtracking2(List<List<Integer>> res,List<Integer> temp,int[] nums,boolean[] visited){
        if (temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=0;i<visited.length;i++){
            //加一个防止重复排列的先决条件
            if (i!=0&&nums[i-1]==nums[i]&&!visited[i-1]) continue;  //i!=0主要是防止程序 下标异常报错
            if (visited[i]) continue;
            visited[i]=true;
            temp.add(nums[i]);
            backtracking2(res,temp,nums,visited);
            //回溯
            temp.remove(temp.size()-1);
            visited[i]=false;
        }
    }
}
