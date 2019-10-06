//package 头条.Test_20190915;
//
//import java.util.Scanner;
//
//public class 夏季特惠 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt(), x = in.nextInt();
//        in.nextLine();
//        int[] a = new int[n];
//        int[] b = new int[n];
//        int[] w = new int[n];
//        int i = 0;
//        while (n-- >= 0) {
//            String s = in.nextLine();
//            String[] ss = s.split(" ");
//            a[i] = Integer.valueOf(ss[0]);
//            b[i] = Integer.valueOf(ss[1]);
//            w[i] = Integer.valueOf(ss[2]);
//            i++;
//        }
//        DPSlove(a,b,w,x,n);
//    }
//    public static int DPSlove(int[] a,int[] b,int[] w,int x,int n){
//        int[][] dp=new int[n][n];
//
//    }
//                 /**
//                * DP算法求解过程
//                * 从下面的代码得到DP在这个问题中的时间复杂度是O(n*w) 相比于回溯算法 解决0-1背包问题需要O(2^n)的是时间复杂度
//                * 但是这个方法里面需要额外申请一个[n][w+1]的二维数组，对空间消耗比较大
//                * 从这里我们也可以看到DP是一个空间换时间的算法
//                */
//        public static int DPSlove2(int[] weight,int[] value,int n,int w){
//            int[][] state=new int[n][w+1];  //定义状态转换表 二维数组）
//            //首先是初始化值  这个其实不需要 初始化为0
////        for (int i=0;i<n;i++){
////           for (int j=0;j<w+1;j++)
////               state[i][j]=-1;
////       }
//            state[0][0]=0;
//            state[0][weight[0]]=value[0];
//            //利用动态规划状态转移
//            for (int i=1;i<n;i++){
//                for (int j=0;j<=w;j++){
//                    //不把第i个物品放入背包 因为这个下标的重量状态已经存在了
//                    if (state[i-1][j]>=0) state[i][j]=state[i-1][j];
//                }
//                for (int j=0;j<=w-weight[i];j++){
//                    //把第i个物品放入背包
//                    if (state[i-1][j]>=0){
//                        int v=state[i-1][j]+value[i];
//                        //状态转换数组中 总是保存当前状态对应的最大总价值
//                        if (v>state[i][j+weight[i]]) state[i][j+weight[i]]=v;
//                    }
//                }
//            }
//            //输出结果
//            int maxValue=-1,maxpos=-1;
//            for (int j=0;j<=w;j++){
//                if (state[n-1][j]>maxValue){
//                    maxValue=state[n-1][j];
//                    maxpos=j;
//                }
//            }
//            System.out.println("the most weight is: "+maxpos);
//            return maxValue;
//        }
//    }
//}
