package 剑指offer;

import java.util.TreeMap;

/**
 * @author xjh 2019.04.16
 * 这题可用TreeMap(红黑树) 或者LinkedHashMap(内部维护一个双向链表 保证顺序)
 * 不能用HashMap 因为数据是按照hashcode值存储的 内部无序
 */
public class 第一个只出现一次的字符 {
    public static int FirstNotRepeatingChar(String str) {
        TreeMap<Character,Integer> map=new TreeMap<>();
        for (char c:str.toCharArray()){
            if (!map.containsKey(c)) map.put(c,1);
            else map.put(c,map.get(c)+1);
        }
        int location=-1;
        for (int i=0;i<str.length();i++){
            char t=str.charAt(i);
            if (map.get(t)==1){
                location=i;
                break;
            }
        }
        return location;
    }

    public static void main(String[] args) {
        String str="google";
        System.out.println(FirstNotRepeatingChar(str));
    }
}
