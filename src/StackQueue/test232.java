package StackQueue;

/**
 * leetcode 232 使用栈实现队列
 * 225 使用队列实现栈
 *采用负负得正的思想 两个换一个
 * @author xjh  2018.11.03
 */

import java.util.Stack;

/**
 * 栈实现队列
 */
class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
    }

    /**
     * 实现入队的功能
     * @param x
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * 实现出队
     * @return
     */
    public int pop() {
        if (s2.isEmpty()) {
            //如果栈s2为空，则将栈s1中的元素出栈 放入栈s1中
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }

    /**
     * 查找某个元素
     * @return
     */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        } else {
            while (!s1.isEmpty())
                s2.push(s1.pop());
            return s2.peek();
        }
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
public class test232 {
}
