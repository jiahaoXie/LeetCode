package 头条;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xjh 2019.03.16
 */
public class test4 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        float[] a=new float[n];
        for (int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        DecimalFormat d=null;
        //先只考虑m<=n
        Arrays.sort(a);//首先排序
        //因为这里讨论的是 最长多少 末尾的元素大于前面的一倍
        DecimalFormat df=new DecimalFormat("0.00");
//        float t=float(a[n-1]/2);
        if (a[n-m]<=a[n-1]/2) System.out.println(df.format(a[n-1]/2));
        else System.out.println(df.format(a[n-m]));

    }
}
