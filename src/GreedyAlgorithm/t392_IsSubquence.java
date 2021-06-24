package GreedyAlgorithm;

/**
 * leetcode 392 Is Subquence
 * leetcode 792 Number of Matching Subsequences
 *
 * @author xjh 2019.03.08
 */
public class t392_IsSubquence {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            //表示从下标index+1开始 查找第一次出现c的位置
            if (index == -1) return false;
        }
        return true;
    }

    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for (String str : words) {
            int index = -1;
            for (char c : str.toCharArray()) {
                index = S.indexOf(c, index + 1);
                if (index == -1) break;
            }
            if (index != -1) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        t392_IsSubquence xjh = new t392_IsSubquence();
//        System.out.println(xjh.isSubsequence("abc","afgsbsjdivc"));
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(xjh.numMatchingSubseq(s, words));
    }
}
