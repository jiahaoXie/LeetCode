package 头条.Test_20190811;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] num=new int[n];
        int[] dollar=new int[n];
        for (int i=0;i<n;i++) num[i]=in.nextInt();
        int j=findMin(num);
        dollar[j]=100;
        if (j==0) dollar[j+1]=200;
        else if (j==num.length) dollar[j-1]=200;
        else dollar[j-1]=dollar[j+1]=200;
        for (int i=0;i<num.length;i++){
            if (num[i]==num[j]) dollar[i]=100;  //存在多个最小值
        }
        for (int i=j+2;i<num.length;i++){
            if (dollar[i]==100) continue;
            else{
                if (num[i]>num[i-1]) dollar[i]=dollar[i-1]+100;
                else if (num[i]==num[i-1]) dollar[i]=dollar[i-1];
                else if(num[i]<num[i-1]&&num[i]<num[i+1]) dollar[i]=100;
                else if (num[i]<num[i-1]&&num[i]>=num[i+1]) dollar[i]=200;
            }
        }
        for (int i=j-2;i>=0;i--){
            if (dollar[i]==100) continue;
            else{
                if (num[i]>num[i+1]) dollar[i]=dollar[i-1]+100;
                else if (num[i]==num[i+1]) dollar[i]=dollar[i+1];
                else if(num[i]<num[i+1]&&num[i]<num[i-1]) dollar[i]=100;
                else if (num[i]<num[i+1]&&num[i]>=num[i-1]) dollar[i]=200;
            }
        }
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=dollar[i];
        }
        System.out.println(sum);
    }
    public static int findMin(int[] num){
        int minNum=num[0],min=0;
        for (int i=1;i<num.length;i++){
            if (minNum>num[i]) min=i;
        }
        return min;
    }
}
