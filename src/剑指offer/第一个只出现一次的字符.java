package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xjh 2019.04.16
 */
public class 第一个只出现一次的字符 {
    public static int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map=new HashMap<>();
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
