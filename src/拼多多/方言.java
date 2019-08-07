package 拼多多;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有n个人 k种方言，每种方言会的人有xi个
 * 输出会说所有方言的最少人数
 *
 *@author xjh 2019.05.06
 */
public class 方言 {
    public static void main(String[] args) {
//        func1();    //方法1
        func2();    //方法2 牛客网里别人ac的答案
    }

    // 方法1 通过率 60% 笔试时思考时 找到最小的a[0]+a[1]并与n进行比较 得出结果
    public static void func1(){
        Scanner in=new Scanner(System.in);
        long n=in.nextInt();
        int k=in.nextInt();
        long[] a=new long[k];
        long sum=0;
        for (int i=0;i<k;i++) {
            a[i]=in.nextInt();  //每种方言会说的人数
        }
        Arrays.sort(a);
        if (a[0]+a[1]<n){
            System.out.println(0);
            return;
        }
        System.out.println(a[0]+a[1]-n);
    }

    //方法2 逆向思维 尽可能找到不会所有语言的人count 然后n-count
    public static void func2(){
        Scanner in=new Scanner(System.in);
        long n=in.nextInt();
        int k=in.nextInt();
        long[] a=new long[k];
        long sum=n;
        for (int i=0;i<k;i++) {
            a[i]=in.nextInt();  //每种方言会说的人数
            a[i]=n-a[i];
            sum=sum-a[i]; //假设每一种语言不会的人 不会重合 这就是最多不会所欲语言的集合体
        }
        if (sum<0) sum=0;
        System.out.println(sum);
    }
}
