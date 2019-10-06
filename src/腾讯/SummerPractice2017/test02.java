package 腾讯.SummerPractice2017;

import java.util.Scanner;

/**
 * 字符移位 两个StringBuffer解决
 * @author xjh 2019.04.04
 */
public class test02 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNextLine()){
            String sc=in.nextLine();
            if (sc.equals("0")) break;
            System.out.println(move(sc));
        }
    }
    public static String move(String sc){
        StringBuffer s1=new StringBuffer(); //小写
        StringBuffer s2=new StringBuffer(); //大写
        for (int i=0;i<sc.length();i++){
            if (sc.charAt(i)>='a'&&sc.charAt(i)<='z') s1.append(sc.charAt(i));
            else s2.append(sc.charAt(i));
        }
        s1.append(s2);
        return s1.toString();
    }
}
