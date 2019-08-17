package T360;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt();
        int[][] a=new int[n][m];
        int sum=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                a[i][j]=in.nextInt();
                sum+=2+(4*a[i][j]);
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){ //逐行减
                if (j==0) continue;
                sum-=2*Math.min(a[i][j],a[i][j-1]);
            }
        }
        for (int j=0;j<m;j++){
            for (int i=0;i<n;i++){ //逐列减
                if (i==0) continue;
                sum-=2*Math.min(a[i][j],a[i-1][j]);
            }
        }
        System.out.println(sum);
    }
}
