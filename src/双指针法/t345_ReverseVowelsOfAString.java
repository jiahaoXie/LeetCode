package 双指针法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 345 Reverse Vowels of a String
 * 双指针法 首先建立一个全局的表示元音的list
 *
 * @author xjh 2019.02.21
 */
public class t345_ReverseVowelsOfAString {
    //先用一个list存储元音字母
    public static List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] res = new char[s.length()];
        while (i <= j) {
            char si = s.charAt(i);
            char sj = s.charAt(j);
            if (!list.contains(si)) res[i++] = si;
            else if (!list.contains(sj)) res[j--] = sj;
            else {
                //两个都包含包含元音字母 互换字母
                res[i++] = sj;
                res[j--] = si;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String input = "hello";
//        System.out.println(input);
        String output = reverseVowels(input);
        System.out.println(output);
    }
}
