package 剑指offer;

/**
 * 用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 这同样是一道需要手动画图的题
 * n==0时，return 0;
 * n==1时，return 1
 * n=2时，return 2
 * n>2时，第一次摆放2*1时 摆放方法为RectCover(n-1) ;第一次摆放为1*2时，第二行也只能放1*2，所以摆放方法为RectCover(n-2)
 * 所以对应的状态转换方程是dp[i]=dp[i-1]+dp[i-2]
 * 当然也可利用回溯来做 return RectCover(n-1)+RectCover(n-2)
 * @author xjh 2019.04.07
 */
public class 矩形覆盖 {
    //暴力回溯法
    public static int RectCover(int n) {
        if (n<1) return 0;
        if (n==1) return 1;
        if (n==2) return 2;
        return RectCover(n-1)+ RectCover(n-2);
    }

    //dp方法
    public static int RectCover2(int n) {
        if (n<1) return 0;
        if (n==1) return 1;
        if (n==2) return 2;
        int[] dp=new int[n+1];
        dp[0]=0;dp[1]=1;dp[2]=2;
        for (int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(RectCover2(10));
    }
}
