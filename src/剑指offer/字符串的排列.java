package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
/**
 * 字符串排列 这道题 有点难度！！
 * @author xjh 2019.04.12
 * 网上大佬的答案 这个代码的原理也是利用回溯算法做全排列  不同于整形数组中的元素做全排列
 * 这里str中的字符 做交换，所有的字符相互之间都做一次交换 穷举得到所有排列的结果
 */
public class 字符串的排列 {
    public static void main(String[] args) {
        String str="abc";
        ArrayList<String> res=Permutation(str);
        for (String s:res)
            System.out.println(s);
    }

    public static ArrayList<String> Permutation(String str) {
       ArrayList<String> res=new ArrayList<>();
       if (str.length()==0) return res;
        backtracking(res,str.toCharArray(),0);
        Collections.sort(res);  //根据题干的输出要求 对齐进行排序
        return res;
    }

    public static void backtracking(ArrayList<String> res,char[] s,int i){
        if (i==s.length-1){
            String val=String.valueOf(s);
            if (!res.contains(val)) res.add(val);   //避免重复值 加入结果res中
            return;
        }
        for (int j=i;j<s.length;j++){
            swap(s,i,j);
            backtracking(res,s,i+1);
            swap(s,i,j);
        }
    }

    public static void swap(char[] s,int i,int j){
        char temp=s[i];
        s[i]=s[j];s[j]=temp;
    }
}
