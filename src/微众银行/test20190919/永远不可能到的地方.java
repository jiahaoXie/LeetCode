package 微众银行.test20190919;

import java.util.Scanner;

public class 永远不可能到的地方 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt();
        int max=0;
        int[][] map=new int[n+1][n+1];
        while (n-->0){
            int t1=in.nextInt(),t2=in.nextInt();
            max=Math.max(max,Math.max(t1,t2));
            map[t1][t2]=map[t2][t1]=1;
        }
        System.out.println(max-1+" "+max);
    }
}

