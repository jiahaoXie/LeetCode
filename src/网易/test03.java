package 网易;

import java.util.Scanner;

/**
 * 网易春招实习真题 第三题  01背包的不同变换 这道题穷举所有的装包法 用回溯解决
 * 题干：有一个包能存放体积为w的物品，有一些体积为v[n]的零食，
 *       现在要在包里装一些零食，输出有多少种装法(其中包里什么也不放也是一种)。
 *       例如 w = 10，v[3] = {1, 2, 4}；那么共有2 * 2 * 2 = 8种装法。
 * @author xjh 2019.03.31
 */
public class test03 {
    public static int count = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n袋零食
        int w = sc.nextInt();//背包容量

        int[] v = new int[n];//每袋零食的体积
        long sum = 0;//零食体积总和
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            sum += v[i];
        }

        if (sum<=w){    //直接输出由2^n次方
            System.out.println((int)Math.pow(2,n));
        }else {
            dfs(0,0,n,v,w);
            System.out.println(count+1);
        }
    }

    public static void dfs(long sum,int cur,int n,int[] v,int w){
        if (cur < n){
            if (sum> w){
                return;
            }
            dfs(sum,cur+1,n,v,w);   //不装cur商品
            if (sum+v[cur]<=w){ //装cur商品
                count++;
                dfs(sum+v[cur],cur+1,n,v,w);
            }
        }
    }
}
