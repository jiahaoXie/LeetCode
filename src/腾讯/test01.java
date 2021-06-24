package 腾讯;

/**
 * 输出两个字符串的最长公共子串
 */
public class test01 {
    public static void main(String[] args) {
        String s1 = "abcdgd";
        String s2 = "bcvbabc";
        if (s1.length() == 0 || s2.length() == 0) System.out.println(0);
        else System.out.println(maxCommon(s1, s2));
    }

    public static String maxCommon(String s1, String s2) {
//        StringBuilder max=new StringBuilder();
        int[][] dp = new int[s1.length()][s2.length()];
        int maxSub = 0;
        int start = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i - 1 >= 0 && j - 1 >= 0) dp[i][j] = dp[i - 1][j - 1] + 1;
                    else dp[i][j] = 1;
                    if (dp[i][j] > maxSub) {
                        maxSub = dp[i][j];
                        start = i - maxSub + 1;
                    }
                } else dp[i][j] = 0;
            }
        }
        return s1.substring(start, start + maxSub);
    }
}
