package 剑指offer_0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 数组中出现次数超过一半的数字 {
    //方法1 hashmap保存key/value值
    public int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else map.put(array[i], map.get(array[i]) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            if (x.getValue() > array.length / 2) {
                res = x.getKey();
            }
        }
        return res;
    }

    //方法2 数组排序后 若存在这样的数，则一定是中间那个数
    public int MoreThanHalfNum_Solution2(int[] array) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[array.length / 2]) count++;
        }
        if (count > array.length / 2) return array[array.length / 2];
        else return 0;
    }
}
