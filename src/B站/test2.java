package B站;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(calcu(n));
    }
    public static int calcu(int n){
        while ((n&1)==0) n>>=1;
        int res=1,temp=3;
        while (temp*temp<=n){
            int k=0;
            while (n%temp==0){
                n/=temp;
                k++;
            }
            res*=k+1;
            temp+=2;
        }
        if (n>1) res<<=1;
        return res;
    }
}
