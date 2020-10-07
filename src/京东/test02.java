package 京东;

import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),v=in.nextInt();
        int[] weight=new int[n];
        int[] value=new int[n];
        DPSlove2(weight,value,n,v);
    }
    public static int DPSlove2(int[] weight,int[] value,int n,int w){
        int[] states=new int[w+1];  //定义以为状态转换数组
        //同样需要对第一个物品做处理
        states[0]=0;
        states[weight[0]]=value[0];
        for (int i=1;i<n;i++){  //  dp
            for (int j=w-weight[i];j>=0;j--){
                //第i个物品放入背包
                //把第i个物品放入背包
                if (states[j]>=0){
                    int v=states[j]+value[i];
                    //状态转换数组中 总是保存当前状态对应的最大总价值
                    if (v>states[j+weight[i]]) states[j+weight[i]]=v;
                }
            }
        }

        //输出结果
        int maxValue=-1,maxpos=-1;
        for (int i=w;i>=0;i--){
            if (states[i]>maxValue){
                maxValue=states[i];
                maxpos=i;
            }
        }
        System.out.println("the most weight is: "+maxpos);
        return maxValue;
    }
}
