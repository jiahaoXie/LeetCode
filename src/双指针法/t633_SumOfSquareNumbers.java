package 双指针法;

/**
 * leetcode 633 Sum of Square Numbers
 * 双指针法 首先选择首尾两个元素
 *
 * @author xjh 2019.02.21
 */
public class t633_SumOfSquareNumbers {
    public static boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);   //选择首尾两个元素
        while ((i * i + j * j) != c) {
            if ((i * i + j * j) > c) j--;
            else if ((i * i + j * j) < c) i++;
            if (i > j) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(9));
    }
}
