package 剑指offer_0;

/**
 * 正则表达式匹配 【这道题有难度！！注意把提纲中的要求看明白,只有模式串中含有'.'或者'*'】
 *
 * @author xjh 2019.04.28
 * 当模式中的第二个字符不是“*”时：
 * 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
 * 2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
 * <p>
 * 而当模式中的第二个字符是“*”时：
 * 如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
 * 如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
 * 1、模式后移2字符，相当于x*被忽略；
 * 2、字符串后移1字符，模式后移2字符；
 * 3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
 */
public class 正则表达式匹配 {
    public boolean match(char[] str, char[] pattern) {
        //边界处理
        if (str == null && pattern == null) return true;
        else if (str != null && pattern == null) return false;

        int strIndex = 0, patternIndex = 0;
        return match(str, strIndex, pattern, patternIndex);
    }

    public boolean match(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) return true;
        if (strIndex != str.length && patternIndex == pattern.length) return false;
        //模式串第二个字符是'*'
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            //模式串第2个是*,且字符串第一个和模式串第一个匹配，分3种情况；如果不匹配，模式串后移2位（表示*前面字符匹配0个）
            if (strIndex < str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')) {
                return match(str, strIndex, pattern, patternIndex + 2) ||
                        match(str, strIndex + 1, pattern, patternIndex + 2) ||
                        match(str, strIndex + 1, pattern, patternIndex);
            } else return match(str, strIndex, pattern, patternIndex + 2);
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if (strIndex != str.length && (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')) {
            return match(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
