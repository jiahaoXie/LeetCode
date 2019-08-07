package 微众银行;

import java.util.Scanner;

public class test02 {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();
        int res=0;
        if (m==1){
           res=n*k;
        }else if (m>=n){
            res=k;
        }else {
            res=n*k/m+1;
        }
        System.out.println(res);
    }
}
