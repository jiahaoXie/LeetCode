package 网易.test20190802;

import java.util.Scanner;

public class 最大值最小值 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        long[] a=new long[n];
        for (int i=0;i<n;i++) a[i]=in.nextLong();
        long[] res=new long[n];
        res[0]=a[0];
        for (int i=1;i<n;i++){
            res[i]=Math.max(res[i-1],a[i]);
        }
        for (int i=0;i<res.length;i++){
            if (i==res.length-1) System.out.print(res[i]);
            else System.out.print(res[i]+" ");
        }
    }
}
