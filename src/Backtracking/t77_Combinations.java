package Backtracking;

import java.util.ArrayList;
import java.util.List;
/**
 * leetcode 77 Conbinations
 * @author xjh 2019.03.26
 * 有点技巧性！
 */
public class t77_Combinations {
    public static void main(String[] args) {
        t77_Combinations xjh=new t77_Combinations();
        List<List<Integer>> res=xjh.combine(4,2);
        for (List<Integer> temp:res)
            System.out.print(temp+" ");
        System.out.println();
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        boolean[] visited = new boolean[n];
        backtracking(res,temp,1,k,n);
        return res;
    }
    public void backtracking(List<List<Integer>> res,List<Integer> temp,int start,int k,int n){
        if (k==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i=start;i<=n-k+1;i++){
            temp.add(i);
            backtracking(res,temp,i+1,k-1,n);
            temp.remove(temp.size()-1);
        }
    }
}
