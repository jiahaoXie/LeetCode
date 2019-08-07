package Sort;

/**
 * leetcode 387 First Unique Character in a String
 * 问题不需要想的太复杂 这个题比较简单
 * @author xjh 2019.02.25
 */
public class t387_FirstUniChar {
    public int firstUniqChar(String s) {
        int[] count=new int[26];
        for (int i=0;i<s.length();i++)
            count[s.charAt(i)-'a']++;   //计算每个字符出现的次数
        for (int i=0;i<s.length();i++){
            if (count[s.charAt(i)-'a']==1) return i;
        }
        return -1;

    }

    public static void main(String[] args) {
        t387_FirstUniChar t=new t387_FirstUniChar();
        String s="leetcodecdascsad";
        System.out.println(t.firstUniqChar(s));
    }
}
