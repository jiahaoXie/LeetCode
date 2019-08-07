package 剑指offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xjh 2019.04.29
 */
public class 字符流中第一个不重复的字符 {
    //方法1 linkedHashmap
    LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch){
        if (map.containsKey(ch)) map.put(ch,map.get(ch)+1);
        else map.put(ch,1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        for (Map.Entry<Character,Integer> m:map.entrySet()){
            if (m.getValue()==1) return m.getKey();
        }
        return '#';
    }

    //方法2 一维数组解决
    //Insert one char from stringstream
    static String s="";
    static char[] hash=new char[256];
    public static void Insert2(char ch)
    {
        s+=ch;
        hash[ch]++;
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce2()
    {

        int size=s.length();
        for(int i=0;i<size;++i)
        {
            if(hash[s.charAt(i)]==1)
                return s.charAt(i);
        }
        return '#';
    }

    public static void main(String[] args) {
        String str="hello";
        for (char c:str.toCharArray()) {
            Insert2(c);
            System.out.print(FirstAppearingOnce2()+" ");
        }

    }
}
