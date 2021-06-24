package 剑指offer_0;

public class Fibonacci {
    //递归解决 时间复杂度是O(2^n)
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    // 方法2 其实原理是DP的思想 知识没有规范化dp方程和dp数组
    public int Fibonacci2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    //方法3
    public int Fibonacci3(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
