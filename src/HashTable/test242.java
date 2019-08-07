package HashTable;

import java.util.Arrays;

//1.第一种解决方法 利用快排得到String的有效顺序 然后进行比较 时间复杂度是O(nlogn)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] ss = s.toCharArray();  //首先将String转换为char[]
        char[] tt = t.toCharArray();

        Arrays.sort(ss);
        Arrays.sort(tt);    //快排 使其数组中的数据有序

        return Arrays.equals(ss, tt);
    }
}

//2.字符计数的方法 时间复杂度是O(n)
class solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}


public class test242 {
}
