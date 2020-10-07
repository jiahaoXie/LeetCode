package 招商银行;

import java.util.Scanner;

/**
 * 暑期实习 IT大数据方向 第一题
 * @author xjh 2019.04.09
 */
public class 实习笔试01 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),a=in.nextInt(),b=in.nextInt(),c=in.nextInt();
        if (n<c){
            System.out.println(0);
            return;
        }
        int buy=n/c;    //可以买多少快
        int count=0;
        if (buy<a){
            System.out.println(buy);
            return;
        }else {
            //buy>=a
            int aa=buy/a;
            int bb=buy%a;
            count+=aa*(a+b);
            count+=bb;
            System.out.println(count);
        }
    }
}
