package 头条;

import java.util.Scanner;

/**
 * @author xjh 2019.03.16
 */
public class test3 {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int time=0;time<n;time++) {
            int[] ratings=new int[sc.nextInt()];
            for(int i=0;i<ratings.length;i++){
                ratings[i]=sc.nextInt();
            }
            if(ratings.length==0){
                System.out.println(0);
                continue;
            }
            if(ratings.length==1){
                System.out.println(ratings[0]);
                continue;
            }
            int[] L = new int[ratings.length];
            for (int i = 0; i < ratings.length; i++) {
                L[i] = 1;
            }
            for(int i=0;i<ratings.length;i++){
                if(ratings[i]>ratings[(i-1+ratings.length)%ratings.length]){
                    L[i]=Math.max(L[(i-1+ratings.length)%ratings.length],L[i])+1;
                }
                if(ratings[i]>ratings[(i+1)%ratings.length]){
                    L[i]=Math.max(L[(i+1)%ratings.length],L[i])+1;
                }
            }

            int sum = 0;
            for (int i = 0; i < L.length; i++) {
                sum += L[i];
            }
            System.out.println(sum);
        }
    }
}
