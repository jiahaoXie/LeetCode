package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 在string中寻找 最长的无重复子串的长度
 * 利用滑动窗口的思想来解决问题
 * @author xjh 2019.05.13
 */
public class t3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        //方法1 利用HashSet来保存最长子串的字符
        //时间复杂度为O(n)[准确的说是O(2*n) 因为i j都有在移动]
//        int n=s.length();
//        Set<Character> set=new HashSet<>();
//        int res=0,i=0,j=0;
//        while (i<n&&j<n){
//            if (!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                res=Math.max(res,j-i);
//            }else set.remove(s.charAt(i++));
//        }
//        return res;

        //方法2 使用HashMap对元素进行数组下标映射 只需要i做移动 时间复杂度为O(n) 由于方法1
        int n=s.length();
        int res=0,i=0,j=0;
        Map<Character,Integer> map=new HashMap<>();
        for (;i<n;i++){
            if (map.containsKey(s.charAt(i))) j=Math.max(map.get(s.charAt(i)),j);//得到上次字符出现的下标位置
            res=Math.max(res,i-j+1);
            map.put(s.charAt(i),i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        t3_LongestSubstringWithoutRepeatingCharacters xjh=new t3_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(xjh.lengthOfLongestSubstring("dvdf"));
    }
}
