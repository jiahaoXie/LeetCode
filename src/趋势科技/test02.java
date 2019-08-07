package 趋势科技;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 田忌赛马 的Java实现
 * @author xjh 2019.04.15
 */
public class test02 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for (int i=0;i<a.length;i++)
            a[i]=in.nextInt();
        Arrays.sort(a);
        int[] b=new int[n];
        for (int i=0;i<b.length;i++)
            b[i]=in.nextInt();
        Arrays.sort(b);

        int ai=0,bi=0,ax=n-1,bx=n-1,count=0;
        boolean flag=true;
        while (flag){
            if (ai==ax) flag=false; //最后一个数
            if (a[ax]>b[bx]){   //最大值相比
                ax--;
                bx--;
                count+=100;
            }
            else if(a[ai]>b[bi]){   //最小值相比
                ai++;bi++;count+=100;
            }else { //A的最小值 和B的最大值相比 故意输
                if (a[ai]<b[bx]) count-=100;
                ai++;
                bx--;
            }
        }
        System.out.println(count);
    }
}
