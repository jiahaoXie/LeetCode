package 拼多多;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入n条线段和一个数字k 找出至少在k条线段的点，输出这些点的最小线段
 * @author xjh 2019.05.07
 * 利用一维数组来存储线段所有可能出现的值 利用两个arraylist来存储线段的起止下标
 */
public class 线段 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),k=in.nextInt();
        int[] arr=new int[20000];
        for (int i=0;i<n;i++){
            int start=in.nextInt();
            int end=in.nextInt();
            start=start*2;end=end*2;
            for (int j=start;j<=end;j++) arr[j]+=1; //得到当前下标值出现的次数
        }
        int start=0,end=0;
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer> a2=new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            if (arr[i]>=k){
                arr[i]=k;   //所有大于k的都视为k
                if (i==0||arr[i-1]!=k) start=i;
            }
            else if (i>0&&arr[i-1]==k){
                end=i-1;
                a1.add(start);  //线段开始下标
                a2.add(end);    //线段结束下标
//                start=end=0;
            }
        }

        System.out.println(a1.size());
        for (int i=0;i<a1.size();i++) System.out.println(a1.get(i)/2+" "+a2.get(i)/2);
    }
}
