package 剑指offer;

/**
 * @author xjh 2019.04.23
 */
public class 翻转单词顺序列 {
    public static String ReverseSentence(String str) {
        if (str.trim().equals(" ")) return str;
            //trim()的作用是去掉字符串两端的多余空格，中间空格不会删掉
//        if(str.equals(" ")) return " ";
        String[] s=str.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i=s.length-1;i>=0;i--){
            if (i!=0)sb.append(s[i]+" ");
            else sb.append(s[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str="student. a am I";
        System.out.println(ReverseSentence(str));
    }
}
