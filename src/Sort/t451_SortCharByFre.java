package Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 451 Sort Characters By Frequency
 * @author xjh 2019.02.25
 */
public class t451_SortCharByFre {
    //这里类似于347 利用桶排序的方法来解
    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1); //初始化map(key value对)
        }

        List<Character>[] buckets = new ArrayList[s.length()+1];  //这里加1是为了防止nums为空 出现数组下标越界的错误
        for (char key : map.keySet()) {
            int value = map.get(key);
            if (buckets[value] == null) buckets[value] = new ArrayList<>();
            buckets[value].add(key);    //将该字符添加到对应频率的桶中
        }

       //因为String是不可变的，所以这里我们利用STringBuilder来添加字符到输出字符串中
        StringBuilder ss=new StringBuilder();
        for (int i=buckets.length-1;i>=0;i--){
            if (buckets[i]==null) continue;
            for (char c:buckets[i]){
                for (int j=0;j<i;j++){  //桶的下标表示该字符出现的次数 所以这里要添加i次 否则输出只有一个字符
                    ss.append(c);
                }
            }
        }
        return ss.toString();
    }
}
