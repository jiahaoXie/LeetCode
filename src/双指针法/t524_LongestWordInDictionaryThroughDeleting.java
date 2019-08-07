package 双指针法;

import java.util.Arrays;
import java.util.List;
/**
 * leetcode 524 Longest Word In Dictionary Through Deleting
 * 这道题有点难度！！！ （s中字母可不连续 相同长度是找最小字符串）
 * @author xjh 2019.02.22
 */
public class t524_LongestWordInDictionaryThroughDeleting {
    public static String findLongestWord(String s, List<String> d) {
        String res = "";  //初始化为空
        for (String t : d) {
            int l1 = res.length(), l2 = t.length();
            if (l1 > l2 || (l1 == l2 && res.compareTo(t) < 0)) continue;
            if (isValid(s, t)) res = t;
        }
         return res;
    }
    /**
     * 判断是否在s中
     */
    public static boolean isValid(String s,String t){
        int i=0,j=0;
        while (i<s.length()&&j<t.length()){
            if (s.charAt(i)==t.charAt(j)) j++;
            i++;
        }
        return j==t.length();
    }

    public static void main(String[] args) {
        String s="abpcplea";
        List<String> d= Arrays.asList("ale","apple","monkey","plea");
        System.out.println(findLongestWord(s,d));
    }
}
