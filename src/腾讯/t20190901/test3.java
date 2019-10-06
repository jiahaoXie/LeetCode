package 腾讯.t20190901;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[] a=new int[n];
        int sum=0;
        for (int i=0;i<a.length;i++) {
            a[i]=in.nextInt();
            sum+=a[i];
        }
        int res=0;
        while (a.length!=0){
            if(m>=sum){
                System.out.println(a.length+1);
                break;
            }else {//有的人需要搬两次

            }
        }
    }
    public static int max(int[] a){
        int max=a[0];
        for (int i=1;i<a.length;i++){
            if (max<a[i]) max=a[i];
        }
        return max;
    }
}
