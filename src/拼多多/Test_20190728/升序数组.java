package 拼多多.Test_20190728;

import java.util.Scanner;

public class 升序数组 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String aa=in.nextLine();
        String bb=in.nextLine();
        String[] a=aa.split(" ");
        String[] b=bb.split(" ");

        int p1=0,p2=0,p21=0,p22=0,pmax=0;
        for (int i=1;i<a.length;i++){
            if (Integer.valueOf(a[i-1])>Integer.valueOf(a[i])){
                p1=i;   //找到目标下标
                p2=cal(a,b,p1);
                break;
            }
            if (Integer.valueOf(a[i-1])== Integer.valueOf(a[i])){
             p21=cal(a,b,i-1);
             p22=cal(a,b,i);
             pmax=Math.max(Integer.valueOf(a[p21]),Integer.valueOf(a[p22]));
            }
        }
        if (p2==0&&pmax==0){
            System.out.println("NO");
            return;
        }
        for (int i=0;i<p1;i++) System.out.print(a[i]+" ");
        System.out.print(b[p2]+" ");
        if (p1==a.length-1) return;
        for (int i=p1+1;i<a.length-2;i++) System.out.print(a[i]+" ");
        System.out.print(a[a.length-1]);
    }

    public static int cal(String[] a,String[] b,int p1){
        int p2=0;
        for (int i=0;i<b.length;i++){
            if (p1==a.length-1&&Integer.valueOf(a[p1-1])< Integer.valueOf(b[i])){
                if (Integer.valueOf(b[p2])<Integer.valueOf(b[i]))
                    p2=i;
            }
            else if (Integer.valueOf(a[p1-1])< Integer.valueOf(b[i])&& Integer.valueOf(a[p1+1])>Integer.valueOf(b[i])){
                if (Integer.valueOf(b[p2])<Integer.valueOf(b[i]))
                    p2=i;
            }
        }
        return p2;
    }
}
