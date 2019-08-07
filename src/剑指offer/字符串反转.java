package 剑指offer;

/**
 * 递归实现字符串反转
 * @author xjh 2019.04.24
 */
public class 字符串反转 {
    public static void main(String[] args) {
        System.out.println(reverse("abcdefg"));
    }
    public static String reverse(String a){
        if (a==null||a.length()<=1) return a;
        return reverse(a.substring(1))+a.charAt(0);
    }
}
