package 滴滴;

import java.util.Scanner;

public class 冒泡排序 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String[] ss=s.split(",");
        int[] a=new int[ss.length];
        for (int i=0;i<a.length;i++) a[i]=Integer.valueOf(ss[i]);
        maopaoSort(a);
        for (int j=0;j<a.length;j++) System.out.print(a[j]+" ");
    }
    public static int[] maopaoSort(int[] a) {
        int temp;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1-i; j++) {
                if (a[j] > a[j+1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }
}
