package 华为;

import java.util.Scanner;
import java.util.Stack;

/**
 * 华为2019春招实习 4.10笔试第二题
 *
 * @author xjh 2019.04.11
 * 利用栈进行计算，每次判断此时是否是右括号，
 * 如果是的话，拿到对应的左括号之前的所有字符，在拿到对应左括号的数字，对字符进行重复以后，全部入栈。
 */
public class test0410_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Stack<String> res = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            String temp = line.charAt(i) + "";
            if (")]}".contains(temp)) {
                //得到上一个对应括号 之前的字母
                StringBuilder sb = new StringBuilder();
                while (!"{[(".contains(res.peek()) && !res.isEmpty()) {
                    sb.append(res.pop());
                }
                res.pop(); //弹出括号

                //接下来是左括号前面的数字 注意可能是多个字符（这是题目中的一个容易忽视地方）
                int num = 0, count = 0;
                while (!res.isEmpty() && res.peek().matches("[0-9]")) {
                    if (count > 0) num += count * 10 * Integer.parseInt(res.pop());
                    else num += Integer.parseInt(res.pop());
                    count++;
                }

                //按照数字 对括号里的字符串进行重复计算 然后入栈
                StringBuilder resStr = new StringBuilder();
                while (num-- > 0) {
                    resStr.append(sb);
                }
                res.push(resStr.toString());
            } else res.push(temp);   //非右括号一律入栈操作
        }
        //结果出栈
        while (!res.isEmpty())
            System.out.print(res.pop());
    }
}
