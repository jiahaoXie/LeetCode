package 剑指offer_0;

/**
 * @author xjh 2019.04.29
 * 边界条件：
 * 1.e必须有数字后面的数字不能有小数点
 * 2.除了e E不能有其他英文字母
 * 3.+-要出现在字符最开始 要么只能出现再e后面一位
 * 4. e后面不能再接小数点 小数点在字符串中不能出现两次
 */
public class 表示数值的字符串 {
    public static boolean isNumeric(char[] str) {
        if (str == null) return false;
        boolean sign = false, decimal = false, hasE = false;  //标记符号 小数点 e(E)是否出现过
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1) return false;  //e不能是最后一位字符
                if (hasE == true) return false; //不能有两个e
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                if (i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
            } else if (str[i] == '.') {
                if (hasE || decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') return false; //出现其他非法字符
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("123e+3".toCharArray()));
    }
}
