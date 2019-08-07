package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 763 Partition Labels
 * @author xjh 2019.02.28
 * 典型的贪心算法  有难度！！
 */
public class t763_763PartitionLabels {
    public List<Integer> partitionLabels(String S) {
    //首先计算出字符串中每个字符的最末尾下标位置
        int[] lastIndex=new int[26];    //表示26个字母最后下标
        for (int i=0;i< S.length();i++)
            lastIndex[charIndex(S.charAt(i))]=i;
            //i是实时字母下标
        List<Integer> loc=new ArrayList<>();    //因为这里事先无法知道要被分割成为多少个子字符串，所以一定是用容器来存储 最终结果
        int first=0;
        //从字符串S首字母开始分割 当该字母当前位置等于对应lastIndex位置时分割
        while (first< S.length()){
            int last=first;
            for (int i=first;i< S.length()&&i<=last;i++){
                int index=lastIndex[charIndex(S.charAt(i))];    //得到他在lastIndex中的位置
                if (index>last) last=index;
            }
            loc.add(last-first+1);  //将当前分割的子字符串加入List中
            first=last+1;
        }
        return loc;
    }
    public int charIndex(char i){
        return i-'a';
    }

    public static void main(String[] args) {
        t763_763PartitionLabels xjh=new t763_763PartitionLabels();
        String s="ababcbacadefegdehijhklij";
        List<Integer>list=xjh.partitionLabels(s);
        for (Integer i:list)
            System.out.print(i+" ");
        System.out.println();
    }
}
