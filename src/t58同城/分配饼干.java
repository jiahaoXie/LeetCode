package t58同城;
/**
 * N个孩子站成一排，给每个人设定一个权重（已知）。按照如下的规则分配糖果：
 (1)每个孩子至少分得一颗糖果
 （2）权重较高的孩子，会比他的邻居获得更多的糖果。
 问：总共最少需要多少颗糖果？请分析算法思路，以及算法的时间，空间复杂度是多少。
 */

import java.util.Arrays;
import java.util.Scanner;

public class 分配饼干 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        if (n==0) return;
        int[] a=new int[n];
        for (int i=0;i<n;i++) a[i]=in.nextInt();
        System.out.println(getMin(a));
    }
    public static int getMin(int[] a){
        int count=0;
        int n=a.length;
        int [] b=new int[n];
        //只有一个小孩，直接返回1
        if(n<2) return 1;

        //每个小孩预先分一颗糖
        Arrays.fill(b,1);
        int j;
        //正扫描
        for( j=1;j<n;j++)
        {
            //权重i大于i-1 ，比前一个多1
            if(a[j]>a[j-1]){
                b[j]=b[j-1]+1;
            }
        }

        //反扫描
        for( j=n-1;j>=1;j--)
        {
            //权重i小于i-1 ，i-1比i多1
            if((a[j]<a[j-1])&&(b[j-1]<(b[j]+1)))
            {
                b[j-1]=b[j]+1;
            }
        }
        for(int k=0;k<n;k++)
        {
            count+=b[k];
        }
        return count;
    }
}
