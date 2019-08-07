package 剑指offer;

import java.util.Stack;

/**
 * 第一个序列是栈的压入序列 判断第二个序列是否为栈的弹出顺序
 * @author xjh 2019.04.10
 */
public class 栈的压入与弹出序列 {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> s = new Stack<>();
        for (int i=0,j=0;i<pushA.length;){
            s.push(pushA[i++]);
            while (j<popA.length&&s.peek()==popA[j]){
                s.pop();
                j++;
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(pushA, popA));
    }
}
