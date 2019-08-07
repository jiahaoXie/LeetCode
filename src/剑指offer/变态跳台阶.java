package 剑指offer;

/**
 * 这一题需要通过数学推导得到规律 有点技巧
 * @author xjh 2019.04.07
 * 这一题 一次可以跳1,2,...,n级 问有多少种跳法
f(1) = 1
f(2) = f(2-1) + f(2-2) =f(1)+f(0)       //f(2-2) 表示2阶一次跳2阶的次数。
f(3) = f(3-1) + f(3-2) + f(3-3)=f(2)+f(1)+f(0)  它也等于2f(2)
...
f(n-1) = f((n-1)-1) + f((n-1)-2) + f((n-1)-3) + ... + f((n-1)-(n-2))+f((n-1)-(n-1))
       =f(0)+f(1)+...+f(n-2)
f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n)
     =f(0)+f(1)+....+f(n-1)  他等于2f(n-1)
所以得到本题跳法： f(n)= 1 [n<=1]
                       =2*f(n-1) [n>1]
 */
public class 变态跳台阶 {
    public static int JumpFloorII(int n) {
        if (n<=1) return 1;
        int[] dp=new int[n+1];
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=2*dp[i-1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }
}
