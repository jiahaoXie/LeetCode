package 携程;

import java.util.Scanner;

public class 任务调度 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int schedule(int m,int[] array) {
//        int res=0;
//        if(m==1){
//            for(int i=0;i<array.length;i++){
//                res+=array[i];
//            }
//        }else{
//            int max=-1;
//            for (int i = 0; i < array.length; i++) {
//                if(array[i]>max) max=array[i];
//            }
//            for(int i=0;i<array.length;i++){
//                res+=array[i];
//                if(res>=max)
//                    break;
//            }
//            if(m>=array.length) res=max;
//        }
//        return res;
        int n=array.length;
        int[][] dp=new int[n+1][m+1];
//        int i = 0, j = 0, k = 0, temp = 0, MaxInt;
        for (int i = 1;i <=n;++i)
        {
            dp[i][1] = dp[i-1][1] + array[i-1];
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=2;j<=m;j++)
            {
                int minvalue=99999;
                for(int k=1;k<i;k++){
                    int temp=Math.max(dp[i][1]-dp[k][1],dp[k][j-1]);
                    if(temp<minvalue)
                    {
                        minvalue=temp;
                    }
                }
                dp[i][j]=minvalue;
            }
        }
        return dp[n][m];
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}
