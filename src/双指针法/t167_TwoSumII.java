package 双指针法;

/**
 * leetcode 167 Two Sum II - Input array is sorted
 * 利用首尾 i j两个指针来解决
 *
 * @author xjh 2019.02.20
 */
public class t167_TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        if (numbers[i] > target) return new int[0];
        while ((numbers[i] + numbers[j]) != target) {
            if (numbers[i] + numbers[j] > target) j--;
            else if (numbers[i] + numbers[j] < target) i++;
            if (i >= j) {
                return new int[0];
            }
        }
        return new int[]{i + 1, j + 1};
    }

    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(num, target);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
