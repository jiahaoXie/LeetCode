package 微众银行;

import java.util.Scanner;

public class test03 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        int[] num=new int[T];
        for (int i=0;i<num.length;i++)
            num[i]=in.nextInt();

        for (int i=0;i<num.length;i++){
            if (num[i]==1){
                System.out.println(0);
                continue;
            }
            int count=0;
            while (num[i]!=1){
                if (num[i]%2==0){   //偶数
                    num[i]=num[i]/2;
                    count++;
                }else{  //奇数
                    num[i]=num[i]*3+1;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
