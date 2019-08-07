package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum
 */
class Solution {
    //所以有时间复杂度计算 得到为O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> s=new ArrayList<>();
        Arrays.sort(nums);  //快排原有数組元素 这里是O(nlogn)
        for(int i=0;i<nums.length-2;i++){   //一次要的到這樣的3個數，所以遍历到倒数第三个数  这里是O(n^2)
            if(i>0&&nums[i]==nums[i-1])
                continue;   //跳过相同元素 因为在i-1时已经比较过了
            int j=i+1,k=nums.length-1;
            int target=-nums[i];
            while (j<k){
                if(nums[j]+nums[k]==target){
                    s.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;k--;
                    while (j<k&&nums[j]==nums[j-1]) j++;
                    while (j<k&&nums[k]==nums[k+1]) k--;
                }else if(nums[j]+nums[k]>target){
                    k--;
                }else j++;
            }
        }
        return s;
    }
}
public class test15 {
}
