package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割字符串使得每个部分都是回文数
 *
 * @author xjh 2019.05.14
 * 经典的回溯算法
 */
public class t131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        doPartition(s, res, temp);
        return res;
    }

    public void doPartition(String s, List<List<String>> res, List<String> temp) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                temp.add(s.substring(0, i + 1));   //substring 截取字符包前不包尾
                doPartition(s.substring(i + 1), res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {  //如果start==end 只有一个字符 直接输出true 一个字符一定是回文
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        t131_PalindromePartitioning xjh = new t131_PalindromePartitioning();
        List<List<String>> res = xjh.partition("aab");
        for (List<String> list : res) System.out.println(list);
    }
}
