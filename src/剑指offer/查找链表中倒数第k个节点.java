package 剑指offer;

/**
 * 链表双指针法
 * @author xjh 2019.04.08
 */
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class 查找链表中倒数第k个节点 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(k==0) return null;
        ListNode p1 = head;
        int i = 1;
        while (p1 != null && i < k) {
            p1 = p1.next;
            ++i;
        }
        if (p1 == null)    //链表一共没有n个节点
            return null;

        ListNode p2 = head;
        while (p1.next != null) {
            //往后遍历链表节点
            p1 = p1.next;
            p2 = p2.next;
        }//循环结束时 p1为尾节点，p2为倒数第n个节点 pre为倒数第n+1个节点
        return p2;
    }
}
