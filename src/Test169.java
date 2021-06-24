import java.util.Arrays;

/**
 * leetcode 169. Majority Element
 *
 * @author xjh  2018.12.10
 */
public class Test169 {
    public int majorityElement(int[] nums) {
        //1.采用map(key/value)的方式存储 输出众数
//        HashMap<Integer,Integer> m=new HashMap<>();
//        for (int i=0;i<nums.length;i++){
//            if(m.containsKey(nums[i])){
//                //如果map中存在该元素
//                m.put(nums[i],m.get(nums[i])+1);    //value值加1
//            }
//            else m.put(nums[i],1);  //首次将该数值加入map中
//        }
//        for (Map.Entry<Integer,Integer> entry:m.entrySet()){
//            if (entry.getValue()>nums.length/2)
//                return entry.getKey();
//        }
//        return 0;

        //2.先将数组排序 因为众数超过n/2个 所以直接输出排序之后的中间位置的元素即可
        Arrays.sort(nums);
        return nums[(int) (nums.length / 2)];
    }
}
