package DP;

/**
 * leetcode 70 Climbing Stairs 每一次是走一步或者两步
 */
public class test70_ClimbingStairs {
    //和斐波拉契序列类似 DP方程：f(n)=f(n-1)+f(n-2) 因为每一次是走一步或者两步
    //方法1 最简单的暴力穷举法 时间复杂度是指数级
    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }
    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    //方法2 方法1的优化 回溯过程剪枝
    public int climbStairs2(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {  //已经有的值 不在往下回溯 直接得到 避免重复计算
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

    //方法3 采用dp来做 他本身符合dp特征 一个阶段三个子结构
    // dp[i]=dp[i−1]+dp[i−2]
    public int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //方法4 这也是我们入门的代码 最简单的使用
    //dp[i]=dp[i−1]+dp[i−2] 有这个简单的状态转换方程
    //这里采用 两个变量保存中间结果 代替DP方法中的状态转换表
    public static int climbStairs3(int n) {
        if (n<=1) return 1;
        int a=1,b=1;
        int sum=0;
        for (int i=2;i<=n;i++){
            sum=a+b;
            a=b;b=sum;
        }
        return sum;
    }
}
