package 微众银行.test20190919;

import java.util.Scanner;

public class 求询问次数 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        long n =in.nextLong();
        long temp=1000003;
        long res=1;
        long i=1;
        do{
            res=res*i%temp;
            i++;
        }while (i<=n);
        System.out.println(res);
    }
}

