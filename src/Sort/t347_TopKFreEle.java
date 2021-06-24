package Sort;

import java.util.*;

/**
 * 优化的方法是桶排序
 * leetcode 347 Top K Frequent Element
 *
 * @author xjh 2019.02.25
 */
public class t347_TopKFreEle {
    //方法1 利用hashmap存储（key为数组中的数值 value为出现的次数） 然后按照value的降序排列
    //性能分析： 运行时间快于78.13%
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else {
                map.put(nums[i], map.get(nums[i]) + 1);    //覆盖原来值
            }
        }
//        for (Map.Entry<Integer,Integer> t:map.entrySet()){
//            System.out.print("key: "+t.getKey()+" value:"+t.getValue()+"    ;");
//        }
//        System.out.println();

        //对valu值进行降序排列 利用Collection.sort()
        //这里将map.entrySet()转换成list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            //升序排序 o1 to o2;降序o2 to o1
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        List<Integer> res = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = list.iterator();
        //这里排序好的值是在list中 原map 值无任何变化
        int i = 0;
        while (i < k) {
            Map.Entry<Integer, Integer> temp = iterator.next();
            res.add(temp.getKey());
            i++;
        }
        return res;
    }

    //方法2 采用桶排序[设置若干个桶，每个桶中存储频率相同的数 并且桶的下标代表桶中数出现的频率，最后从后向前遍历桶 得到k个数]
    //桶排序的性能为99.25%
    public List<Integer> topKFrequent2(int[] nums, int k) {
        //首先还是用hashmap去存储对应的值的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); //初始化map
        }

        for (Map.Entry<Integer, Integer> t : map.entrySet()) {
            System.out.print("key: " + t.getKey() + " value:" + t.getValue() + "  ");
        }
        System.out.println();

        List<Integer>[] buckets = new ArrayList[nums.length + 1];  //这里加1是为了防止nums为空 出现数组下标越界的错误
        for (int key : map.keySet()) {
            int value = map.get(key);   //value
            if (buckets[value] == null) buckets[value] = new ArrayList<>();
            buckets[value].add(key);    //将该数值添加到对应频率的桶中
        }
        List<Integer> topK = new ArrayList<>();  //这里就初始化一个值范围k个数
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] != null) topK.addAll(buckets[i]);
        }
        return topK;
    }

    public static void main(String[] args) {
        t347_TopKFreEle xjh = new t347_TopKFreEle();
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        System.out.println(xjh.topKFrequent2(nums, k));
    }
}
