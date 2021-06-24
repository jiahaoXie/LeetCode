package 剑指offer_0;

/**
 * 调整数组顺序使奇数位于偶数前面,保证奇数之间 偶数之间 相对位置不变
 *
 * @author xjh 2019.04.08
 */
public class 调整数组顺序 {
    //方法1 申请一个辅助数组 用于保存调整数组的结果 最后将值复制给原数组、
    //时间复杂度O(n) 空间复杂度是O(n)
    public static void reOrderArray(int[] array) {
        if (array == null || array.length == 0) return;
        int n = array.length;
        int[] res = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 1) res[j++] = array[i];
        }
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 0) res[j++] = array[i];
        }
        for (int i = 0; i < n; i++) {
            array[i] = res[i];
        }
    }

    //有没有方法 可以不用申请额外数组 直接得到呢？？
    //可以用冒泡或者插入排序 来解决 时间复杂度是O(n^2)
    public static void reOrderArray2(int[] array) {
        if (array == null || array.length == 0) return;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                //将满足条件的前后交换 这里用的是冒泡排序
                if (array[j] % 2 == 1 && array[j - 1] % 2 == 0) swap(j, j - 1, array);
            }
        }
    }

    public static void swap(int j, int i, int[] array) {
        int t = array[j];
        array[j] = array[i];
        array[i] = t;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        reOrderArray2(array);
        for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
    }
}
