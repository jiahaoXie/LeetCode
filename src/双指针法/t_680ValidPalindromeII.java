package 双指针法;

/**
 * leetcode 680 Valid Palindrome II
 * 双指针法
 *
 * @author xjh 2019.02.21
 */
public class t_680ValidPalindromeII {
    public static boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isValid(s, i + 1, j) || isValid(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isValid(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "abc";
        System.out.println(validPalindrome(input));
    }
}
