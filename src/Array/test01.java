package Array;


import java.util.HashMap;
import java.util.Map;

/**
 * @author xjh 2018.10.15
 * 注意：psvm是main函数的快捷键
 */
public class test01 {
    public static void main(String[] args) {
//        ArrayList<Integer> list=new ArrayList<>();
//        int[] a=new int[]{1,2,4,6,9,13};
//        int target=10;
//        int[] result=twoSum(a,target);
//        for(int i=0;i<result.length;i++){
//            System.out.print(result[i]+" ");
//        }
//        System.out.println();

        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);    // false
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k);   // true
    }

    /**
     * 这里利用HashMap的方法 只需要遍历 比较一遍数组值  时间复杂度为O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();   //HashMap中 以为数组中的元素值作为key,下标作为value.因为程序最终输出结果为下标
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (map.containsKey(t)) {
                return new int[]{map.get(t), i};
            }
            map.put(nums[i], i); //存入map中去
        }
        return new int[]{};
    }

    public static int[] two(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[0];
    }
}
