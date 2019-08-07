package 华为;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 华为第二题 图论 求最短路径  答案不对~
 * @author xjh 2019.04.25
 */
public class test0424_2 {
    public static int m,n;
//    public static int[][] a=new int[100][100];//邻接矩阵
//    public static int[] d=new int[100];    //距离
//    public static int[] visted=new int[100];//访问标记数组
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        m=in.nextInt(); //m个节点
        n=in.nextInt(); //n条边
        int[][] a=new int[m+1][m+1];//邻接矩阵
        int[] d=new int[m+1];    //距离
        int[] visted=new int[m+1];//访问标记数组

        Arrays.fill(d,10000);
        for (int i=0;i<=m;i++) a[i][i]=0;

        int[] temp=new int[4];
        for (int i=1;i<=n;i++){
            temp[0]=in.nextInt();   //这个没用
            temp[1]=in.nextInt();
            temp[2]=in.nextInt();
            temp[3]=in.nextInt();
            a[temp[1]][temp[2]]=temp[3];
            a[temp[2]][temp[1]]=temp[3];
        }
        int start=in.nextInt(),end=in.nextInt();
        dij(start,end,d,visted,a);
        if (d[end]==10000) System.out.println("NA");
        else System.out.println(d[end]);
    }
    public static void dij(int start,int end,int[] d,int[] visited,int[][] a){
        //首先初始化邻接矩阵一个初始值-1 对角线的值为0
        Arrays.fill(d,-1);
        Arrays.fill(visited,0);
        d[start]=0;
        for (int i=1;i<m;i++){
            int current=0;
            for (int j=1;j<=m;j++){
                if (visited[j]==0&&(current==0||d[j]<d[current])) current=j;
            }
            visited[current]=1;
            if (current==end) break;
            if (current!=end) d[current]--; //题干中换乘站减一元
            for (int j=1;j<=m;j++) d[j]=Math.min(d[j],d[current]+a[current][j]);
        }
    }
}
