package 京东;

import java.util.Scanner;

public class test_41301 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();

        //27%样例
//        int count=0;
//        for (int i=0;i<str.length();i++){
//            if (str.charAt(i)=='1') count++;
//        }
//        System.out.println(count);

        int count,sum=0,max=0;
        boolean flag=false;
        for (int i=0;i<str.length();i++){
            count=0;
            if (str.charAt(0)!='1') flag=true;
            if (str.charAt(str.length()-1)!='1') flag=true;
            if (str.charAt(i)=='1'){
                //找到第一个为1的元素
                count++;
                while (i<str.length()-1&&str.charAt(++i)=='1') count++;   //连续1的个数
                max=Math.max(max,count);
                sum+=count; //累计1的总和
            }
        }

        if (flag) System.out.println(max);
        else System.out.println(sum);
    }
}
