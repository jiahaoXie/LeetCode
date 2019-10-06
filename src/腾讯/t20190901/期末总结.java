package 腾讯.t20190901;
import java.util.Scanner;
public class 期末总结 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n = scan.nextInt();
        int[] score = new int[n];
        for(int i=0;i<n;i++) {
            score[i] = scan.nextInt();
        }

        scan.close();
        long max = 0;
        for(int i=0;i<score.length;i++) {
            long sum = 0;
            int min = score[i];
            for(int j=i;j<score.length;j++) {
                sum +=score[j];
                if(score[j]<min)min = score[j];
                long multi = min*sum;
                if(multi>max)max = multi;
            }
        }
        System.out.print(max);
    }
}
