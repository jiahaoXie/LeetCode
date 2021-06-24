package 携程;

import java.util.Scanner;

public class 链表排序 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head, int x) {
//        ListNode root=new ListNode(0);
//        ListNode pre=root;     //指向第一个大于或者等于x的节点前一个节点
//        ListNode p=head;
//        root.next=head;
//        while(p!=null&&p.val<=m){
//            pre=p;
//            p=p.next;
//        }
//        ListNode q=pre;      //保持链表不断
//        while(p!=null){
//            if(p.val<=m){
//                q.next=p.next;     //保证链表不断，将p 插入到pre的后面
//                p.next=pre.next;
//                pre.next=p;
//                pre=p;
//                p=q;
//            }
//            q=p;
//            p=p.next;
//        }
//        return root.next;

        //方法2 使用两个指针来分别指向两个部分 最后拼接
        ListNode root1 = new ListNode(0);
        ListNode q1 = root1;
        ListNode root2 = new ListNode(0);
        ListNode q2 = root2;
        ListNode p = head;
        while (p != null) {
            if (p.val <= x) {
                q1.next = p;
                q1 = q1.next;
            } else {
                q2.next = p;
                q2 = q2.next;
            }
            p = p.next;
        }
        q2.next = null;  //如果链表的最后一个元素小于X则q2的最后一个元素不为空，必须置空
        q1.next = root2.next;
        return root1.next;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        while (in.hasNextInt()) {
            int v = in.nextInt();
            if (v == 0) break;
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }
}
