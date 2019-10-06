package 腾讯.SUmmerPractice2019;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 腾讯实习编程第三题 打怪兽
 * @author xjh 2019.04.05
 */
public class test03 {
    static int result=Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] attack=new int[N];
        for(int i=0;i<N;i++){
            attack[i]=sc.nextInt();
        }
        int[] nums=new int[N];
        for(int i=0;i<N;i++){
            nums[i]=sc.nextInt();
        }
        ArrayList<Integer> list=new ArrayList<>(2);
        list.add(nums[0]);
        list.add(attack[0]);
        recursive(attack,nums,list,1,N);    //回溯算法
        System.out.println(result);
    }

    private static void recursive(int[] attack, int[] nums, ArrayList<Integer> list, int i, int n) {
        if(i==n-1){
            if(list.get(1)<attack[i]){
                int coin=list.get(0)+nums[i];
                result=result>coin?coin:result;
            }else{
                int coin=list.get(0);
                result=result>coin?coin:result;
            }
        }else{
            if(list.get(1)>=attack[i]){
                recursive(attack,nums,list,i+1,n);
            }
            ArrayList<Integer> list2=new ArrayList<>(list);
            list2.set(0, list2.get(0)+nums[i]);
            list2.set(1, list2.get(1)+attack[i]);
            recursive(attack,nums,list2,i+1,n);
        }
    }
}
