package 携程;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 表达式解析 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static String resolve(String expr) {
        if(expr == null || expr.length() ==0){
            return "";
        }
        int length = expr.length();
        int left = 0;
        int right = 0;

        for(int i = 0; i < length; i++){
            if(expr.charAt(i) == '('){
                left++;
            }
            if(expr.charAt(i) == ')'){
                right++;
            }
        }
        if(left !=right){
            return "";
        }

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < expr.length(); i++){
            char charAt = expr.charAt(i);
            if(charAt != ')'){
                stack.push(charAt);
            }else {
                queue.clear();
                while(stack.peek() != '('){
                    queue.add(stack.pop());
                    continue;
                }
                stack.pop();
                while(!queue.isEmpty()){
                    stack.push(queue.poll());
                }
            }
        }
        StringBuilder sss = new StringBuilder();
        while(!stack.isEmpty()){
            sss.append(stack.pop());
        }
        sss.reverse();
        return sss.toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}

