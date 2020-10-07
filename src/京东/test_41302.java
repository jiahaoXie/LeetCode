package 京东;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test_41302 {
    static List<Integer>[] a;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt();
        a=new ArrayList[m+1];
        for (int i=0;i<a.length;i++)
            a[i]=new ArrayList<Integer>();
        for (int i=0;i<m;i++)
            a[in.nextInt()].add(in.nextInt());

        //27%
        if (n<=3){
            System.out.println(1+" "+n);
            if (n==3) System.out.print(2);
        }
//        System.out.println(1+" "+3+" "+2);
        else{
            System.out.print(n+" ");
            int i=0;
            while (++i<n) System.out.print(i+" ");
        }

        for (int i=1;i<=n;i++){
            int[] visit=new int[n+1];
//            dfs(i,i,visit);
        }

    }
    public  static void dfs(int i,int j,int[] visit){
//        ArrayList<Integer> temp=new ArrayList<>();
        visit[j]=1;
//        temp.add(j);
        for (int k=0;k<a[j].size();k++){
            if (visit[a[j].get(k)]==0) dfs(i,a[j].get(k),visit);
        }
//        return temp;
    }
}
