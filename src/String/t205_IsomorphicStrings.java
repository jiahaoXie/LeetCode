package String;

/**
 * 205 字符串同构
 * @author xjh 2019.04.24
 * 记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构。
 */
public class t205_IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length()) return false;
        //定义来两个数组用于存放每个字母的个数
        int[] ssum=new int[256];
        int[] tsum=new int[256];
        for (int i=0;i<s.length();i++){
            if (ssum[s.charAt(i)]!= tsum[t.charAt(i)]) return false;
            ssum[s.charAt(i)]=i+1;  //这里写i+1 是为了阻止 aa ab这样的判定为true的例子
            tsum[t.charAt(i)]=i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg","add"));
    }
}
