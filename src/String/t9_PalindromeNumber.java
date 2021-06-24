package String;

/**
 * 判断一个数是否为回文数
 *
 * @author xjh 2019.04.24
 * 要求不能使用额外区间 所以不能把整数转换为String来做
 * 这里将整数拆解为左右两部分，右边需要转置，然后判断两部分是否相等
 */
public class t9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int right = 0;
        while (x > right) {
            right = right * 10 + x % 10;
            x = x / 10;
        }
        return x == right || x == right / 10;
    }
}
