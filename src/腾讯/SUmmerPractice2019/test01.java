package 腾讯.SUmmerPractice2019;

import java.util.Scanner;
import java.util.Stack;

/**
 * 腾讯暑期实习笔试题 01清除
 * @author xjh 2019.04.05
 */
public class test01 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String sc=in.nextLine();
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<sc.length();i++){
            if (stack.isEmpty()){
                stack.push(sc.charAt(i));
                continue;
            }
            if ((stack.peek()=='1'&&sc.charAt(i)=='0')||(stack.peek()=='0'&&sc.charAt(i)=='1')){
                //消除栈顶元素
                stack.pop();
            }else stack.push(sc.charAt(i));
        }
        int count=0;
        while (!stack.isEmpty()){
            stack.pop();
            count++;
        }
        System.out.println(count);
    }
}
