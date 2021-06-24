package 剑指offer_0;

/**
 * @author xjh 2019.04.07
 */
public class 二进制中1的个数 {
    //方法1 直接调用Java中的方法 统计字符串中1的个数
    public int NumberOf1(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }

    //方法2 因为n有可能是负数 补码首为为1 所以不能采用n右移 而是采用1左移(低位补0)
    public static int NumberOf1_2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);  //消除n 二进制中最低位的1
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1_2(10));
    }
}
