package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 39 Conbination Sum
 * leetcode 40 Combination Sum II
 * leetcode 216 Combination Sum III
 * @author xjh 2019.03.27
 * 最优解
 */
public class t39_CombinationSum {
    public static void main(String[] args) {
        t39_CombinationSum xjh=new t39_CombinationSum();
//        int[] num={2,5,2,1,2};
//        int target=5;
//        List<List<Integer>> res=xjh.combinationSum2(num,target);
//        for (List<Integer> temp:res)
//            System.out.println(temp);

        List<List<Integer>> res=xjh.combinationSum3(3,9);
        for (List<Integer> temp:res)
            System.out.println(temp);
    }
    //39题
    //这里待找到和为target的数据 candidates中的值可以多次重复使用 这样思考比较复杂 也难以编程
    //换种思路 每次只比较候选数组当前下标值与target的值 递归函数 知道target减小到0才终止
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        backtraking(res,temp,0,candidates,target);
        return res;
    }
    //关键在于每次递归时的 start和target的灵活使用
    public void backtraking(List<List<Integer>> res,List<Integer> temp,int start,int[] cand,int target){
        if (target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=start;i< cand.length;i++){
            if (cand[i]<=target){
                temp.add(cand[i]);
                backtraking(res,temp,i,cand,target-cand[i]);
                temp.remove(temp.size()-1);
            }
        }
    }

    //40题 对比39题 40题的题干要求是数组中的元素智能使用一次 所以这里需要设置visited数组标记元素是否访问
    //编程方法参考 47之于46题
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        boolean[] visited=new boolean[candidates.length];
        Arrays.sort(candidates);    //含相同元素首先对齐进行一次排序
        backtraking2(res,temp,0,candidates,target,visited);
        return res;
    }
    public void backtraking2(List<List<Integer>> res,List<Integer> temp,int start,int[] cand,int target,boolean[] visited){
        if (target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=start;i< cand.length;i++){
            if (i!=0&&cand[i-1]==cand[i]&&!visited[i-1]) continue;  //i!=0主要是防止程序 下标异常报错
            if (cand[i]<=target){
                visited[i]=true;
                temp.add(cand[i]);
                backtraking2(res,temp,i+1,cand,target-cand[i],visited);
                visited[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }

    //216题 K个1到9的数相加为n
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        boolean[] visited=new boolean[9];
        backtracking3(res,temp,1,k,n,visited);
        return res;
    }
    public void backtracking3(List<List<Integer>>res,List<Integer> temp,int start,int k,int n,boolean[] visited){
        if (k==0||n==0){
            if (k==0&&n==0) res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=start;i<=9;i++){
                temp.add(i);
                backtracking3(res,temp,i+1,k-1,n-i,visited);
                temp.remove(temp.size()-1);
        }
    }
}
