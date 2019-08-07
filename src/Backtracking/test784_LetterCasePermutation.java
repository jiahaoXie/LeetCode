package Backtracking;

import java.util.*;

/**
 * leetcode 784 Letter Case Permutation
 * 这道题可以用递归树画出 这道题如果全是字母的话 类似是一颗根节点为空的满二叉树
 * 利用回溯算法来写
 * @author xjh 2019.01.08
 */
public class test784_LetterCasePermutation {
    public static List<String> letterCasePermutation(String S) {
       if (S==null) return Collections.emptyList();
       Set<String> set=new HashSet<>();
        DFS(S.toCharArray(),set,0);
        return new ArrayList<>(set);
    }

    /**
     * 这道题可以用递归树画出 这道题如果全是字母的话 类似是一颗根节点为空的满二叉树 
     */
    public static void DFS(char[] ss,Set<String> set,int pos){
        //递归终止条件
        if (pos==ss.length){
            set.add(String.valueOf(ss));
            return;
        }
        if (ss[pos]>='0'&&ss[pos]<='9'){
            //不进行转换 直接看字符串的下一位
            DFS(ss,set,pos+1);
        }
        ss[pos]=Character.toLowerCase(ss[pos]);
        DFS(ss, set,pos+1);
        ss[pos]=Character.toUpperCase(ss[pos]);
        DFS(ss,set,pos+1);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        List<String> list=letterCasePermutation(s);
        for (int i=0;i<list.size();i++)
            System.out.print(list.get(i)+" ");
        System.out.println();
    }
}
