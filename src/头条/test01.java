package 头条;

import java.util.Scanner;

/**
 * @author xjh 2019.03.16
 */
public class test01 {
public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int n=in.nextInt();
    int m=1024-n;
    int count=0;    //表示硬币数
    if (m>=64){
        count+=m/64;
        m=m%64;
    }
    if(m>=16){
        count+=m/16;
        m=m%16;
    }
    if (m>=4){
        count+=m/4;
        m=m%4;
    }
    if(m>0)
        count+=m;
    System.out.println(count);
}
}
