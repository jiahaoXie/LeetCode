package LinkedList;

/**
 * leetcode 83 Remove Duplicates from Sorted List
 * leetcode 82 Remove Duplicates from Sorted List II
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class t83_RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates83(ListNode head) {
        if (head==null) return null;
        ListNode p1=head,p2=head.next;
        while (p2!=null){
            if (p1.val==p2.val) p1.next=p2.next;
            else{
                p1.next=p2;
                p1=p2;
            }
            p2=p2.next;
        }
        return head;
    }

    //代码1  leetcode这个答案写的简化
    public static ListNode deleteDuplicates82(ListNode head) {
        if (head==null) return null;
        ListNode dump=new ListNode(0);
        dump.next=head;
        ListNode pre=dump,cur=head;
        while (cur!=null){
            //未到链表末端 并且相邻的数值相等时 指针后移
            while (cur.next!=null&&(cur.val==cur.next.val)) cur=cur.next;
            if (pre.next==cur) pre=pre.next;    //这里pre.next==cur表示判断是否为同一个节点（不仅值相同 而且next也要相同）
            else pre.next=cur.next;
            cur=cur.next;
        }
        return dump.next;
    }

    //方法2 比较好理解
    public static ListNode deleteDuplicates82To2(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode dump=new ListNode(0);
        dump.next=head;
        //使用前 中 后三个指针可能好理解一些
        ListNode pre=dump,cur=head,next=null;
        while (cur!=null&&cur.next!=null){
            next=cur.next;
            if (pre.val==next.val){
                //如果当前节点值和下一个节点值相等
                while (next!=null&&next.val==cur.val) next=next.next;
                pre.next=next;  //删除相同值的多个节点
                cur=next;
            }else {
                //不做删除 向后遍历
                pre=cur;
                cur=cur.next;
            }
        }
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode p1=new ListNode(1);
        ListNode p2=new ListNode(2);
        ListNode p3=new ListNode(2);
        ListNode p4=new ListNode(2);
        ListNode p5=new ListNode(4);
        p1.next=p2;p2.next=p3;p3.next=p4;p4.next=p5;
        deleteDuplicates82(p1);
        while (p1!=null){
            System.out.print(p1.val+" ");
            p1=p1.next;
        }
    }
}
