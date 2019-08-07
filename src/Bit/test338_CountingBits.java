package Bit;

import java.util.Scanner;

/**
 * leetcode 338.Counting Bits
 * @author xjh 2019.01.04
 */
public class test338_CountingBits {
    public static int[] countBits(int num) {
        int[] count=new int[num+1];
        //因为count[0]一定为0 所以循环下标从1开始
        //这里的时间复杂度是O(n)
        for (int i=1;i<count.length;i++){
            count[i]=count[i&(i-1)]+1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        int[] count=countBits(num);
        for (int i=0;i<count.length;i++)
            System.out.print(count[i]+" ");
        System.out.println();
    }
}
