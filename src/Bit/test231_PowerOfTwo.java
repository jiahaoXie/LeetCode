package Bit;

/**
 * leetcode 231. Power of Two
 *
 * @author xjh 2019.01.04
 */
public class test231_PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        //关于是2^n的数，在其二进制表示时只有一位是1 其余都是0，所以我们利用这条性质
        if (n <= 0) return false;
        else if ((n & n - 1) == 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(9));
    }
}
