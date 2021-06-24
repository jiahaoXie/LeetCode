package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 414 Third Maximum Number
 *
 * @author xjh 2019.02.24
 */
public class t414_ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        //方法1 先用快排排好序 然后将无重复存储前3个数 时间快于80.56%
        Arrays.sort(nums);  //首先排序好
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!list.contains(nums[i])) list.add(nums[i]);
            if (list.size() >= 3) break;
        }
        if (list.size() >= 3) return list.get(2);
        else return list.get(0);
    }

    public static void main(String[] args) {
        t414_ThirdMaximumNumber t = new t414_ThirdMaximumNumber();
        int[] nums = {2, 2, 3, 1};
        System.out.println(t.thirdMax(nums));
    }

}
