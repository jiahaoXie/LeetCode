package DP;

/**
 * 只有数字的字符串 解码 有多少种组合？
 *
 * @author xjh 2019.06.10
 * A->1 B->2 ... Z->26
 */
public class test91DecodeWays {
    public static void main(String[] args) {
        test91DecodeWays xjh = new test91DecodeWays();
        System.out.println(xjh.numDecodings("123"));
    }

    // 1.dp思想来做这道题 最优子结构 无后向性 重复子数组
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;    //哨兵作用
        dp[1] = s.charAt(0) == '0' ? 0 : 1; //dp[1]的输出
        for (int i = 2; i <= s.length(); i++) {
            //这题的关键在于 正确写出dp方程
            int one = Integer.valueOf(s.substring(i - 1, i));    //substring(s,e) 包前不包后
            if (one != 0) dp[i] += dp[i - 1];
            if (s.charAt(i - 2) == '0') continue;
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two <= 26) dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
