package 美团;

import java.util.Scanner;

/**
 * 美团春招笔试第一题健身
 * 大佬的说法 这是取最小公倍数的问题，n+1和n*4的最小公倍数。
 * 因为n+1和n只有在n==1时有倍数关系。其他情况下不会有公因数，那么只要看n+1和4的公因数，
    * 如果余数为0，那么取n+1；余数为2，取2n+1；其他情况为4n+1;
 * @author xjh 2019.04.24
 */
public class 健身 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            int n=sc.nextInt();
//            if(n%2==0) System.out.println(4*n+1);
//            else if(n%4==1) System.out.println(2*n+1);
//            else System.out.println(n+1);
            if (n%4==0) System.out.println(n+1);
            else if (n%4==2) System.out.println(2*n+1);
            else System.out.println(4*n+1);
        }
    }
}
