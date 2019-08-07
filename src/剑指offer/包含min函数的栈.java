package 剑指offer;

import java.util.Stack;
/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @author xjh 2019.04.09
 * 题目的关键在于 实现O(1)内找到栈中的最小数 stack2栈顶元素 永远保存的是当前的最小值元素
 */
public class 包含min函数的栈 {
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();    //stack2作为辅助栈 栈顶元素为访问的最小数
    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty()) stack2.push(node);
        else if(node<=stack2.peek()) stack2.push(node);
    }

    public void pop() {
        if (stack2.peek()==stack1.peek()) stack2.pop();
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    //得到栈中最小元素的min函数
    public int min() {
        return stack2.peek();
    }
}
