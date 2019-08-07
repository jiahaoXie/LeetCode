package StackQueue;

/**
 * 225 使用队列实现栈
 *采用负负得正的思想 两个换一个
 * @author xjh  2018.11.03
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 */
class MyStack {
    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();
    //    Queue<Integer> temp=new LinkedList<>();
    private  int top;
    MyStack(){}
    public void push(int x){
        q2.add(x);
        top=x;
    }
    public int top(){
        return top;
    }

    /**
     * 实现出栈的功能
     */
    public int pop(){

        while (q1.size()>1){
            top=q1.remove();    //这里是为了更新top值
            q2.add(top);
            //利用辅助队列存储q1前n-1给我元素
        }
        int t=  q1.remove();
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return t;
    }
    public boolean empty(){
        return q1.isEmpty()&&q2.isEmpty();
    }
}
public class test225 {
}
