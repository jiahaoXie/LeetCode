package Bit;

/**
 * leetcode 191 Number of 1 Bits
 */
public class test191_Numberof1Bits {
    public int hammingWeight(int n) {
        int count=0;
        //这里无论是方法1 还是方法2，考察的点都是在最末尾一位为1
        //方法1 所有位与2取模
//        while (n!=0){
//            if (n%2==1) count++;
//            n=n>>1;
//        }
        //方法2 x=x&(x-1)
        while (n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
