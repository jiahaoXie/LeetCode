package Sort;

/**
 * leetcode 75 Sort Colors
 * 采用计数排序 [桶排序的一种特殊情况(要排序的n个数范围不大时)]
 *
 * @author xjh 2019.02.26
 */
public class t75_SortColors {
    //通过率100%
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        //首先统计每个出现的次数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count[0]++;
            else if (nums[i] == 1) count[1]++;
            else count[2]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[k++] = i;
            }
        }
    }
}
