package 剑指offer;

/**
 * @author xjh 2019.04.28
 */
public class 把字符串转换成整数 {
    public static int StrToInt(String str) {
        int num=0;
        boolean flag=false;
        for (int i=0;i<str.length();i++){
            if (i==0){
                if (str.charAt(i)=='-') flag=true;
                if (str.charAt(i)=='+') flag=false;
            }
            else if (str.charAt(i)>='0'&&str.charAt(i)<='9') num=num*10+(str.charAt(i)-'0');
            else {
                return 0;
            }
        }
        if (flag) num=~num+1;   //正数取反加1 得到负数的补码
        return num;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("-2147483647"));
    }
}
