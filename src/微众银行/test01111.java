package 微众银行;

import java.util.ArrayList;
import java.util.Scanner;

public class test01111 {
    public static int LastRemaining_Solution(int n, int m)
    {
        if(n==0||m==0)return -1;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++) {
            list.add(i);
        }
        int s=0;
        while(list.size()>1) {
            System.out.print(list.remove((s+m-1)%n)+" ");

            s=(s+m-1)%n;n--;
        }
        System.out.println();
        return list.get(0);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        System.out.println(LastRemaining_Solution(n,m));
    }
}
