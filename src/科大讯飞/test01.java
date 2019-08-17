package 科大讯飞;

import java.util.Arrays;
import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input=in.nextLine();
        StringBuilder ss=new StringBuilder();
        for (int i=0;i<input.length();i++){
            if (Character.isDigit(input.charAt(i))) ss.append(i);
//            int tmp=input.charAt(i)-'0';
//            if (tmp>=0&&tmp<=9) ss.append(input.charAt(i));
        }
        char[] res=ss.toString().toCharArray();
        if (res.length==0) System.out.println(-1);
        else {
            Arrays.sort(res);
            for (int i=0;i<res.length;i++)
                System.out.print(res[i]-'0');
        }
    }
}
