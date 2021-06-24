package 剑指offer_0;

/**
 * 这道题的解是用归并排序来做,比较经典 常看！！！
 *
 * @author xjh 2019.04.17
 */
public class 数组中的逆序对 {
    //方法1 冒泡排序 时间复杂度是O(n^2) 50% 超时
    public static int InversePairs(int[] array) {
        Long count = 0l;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) count++;
            }
        }
        int res = (int) (count % 1000000007);
        return res;
    }

    //方法2 归并排序 时间复杂度是O(nlogn)
    public static int InversePairs2(int[] array) {
        if (array == null || array.length == 0) return 0;
        int[] copy = new int[array.length];
        int count = InversePairsCore(array, copy, 0, array.length - 1);//数值过大求余
        return count;
    }

    private static int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j >= mid + 1) {
            if (array[i] > array[j]) {
                //过程：先把数组分割成子数组，先统计出子数组内部的逆序对的数目，然后再统计出两个相邻子数组之间的逆序对的数目。
                // 在统计逆序对的过程中，还需要对数组进行排序。
                count += j - mid;
                copy[locCopy--] = array[i--];
                if (count >= 1000000007)//数值过大求余
                {
                    count %= 1000000007;
                }
            } else copy[locCopy--] = array[j--];
        }

        while (i >= low)
            copy[locCopy--] = array[i--];
        while (j > mid)
            copy[locCopy--] = array[j--];

        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
        return (leftCount + rightCount + count) % 1000000007;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs2(array));
    }
}
