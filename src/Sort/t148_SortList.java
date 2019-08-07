package Sort;

/**
 * leetcode 148 Sort List
 * 对链表中的节点数值进行排序 这是一道很经典的归并排序题目（采用分治的思想）
 * 这道题有点难度， 2018年底 腾讯补招一面问题这道题
 * @author xjh 2019.02.26
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null) return head;
        //1.分  利用递归将数值一分为二，直到无法再分
        //因为是单链表结构 所以这里需要用快慢指针法每次找到链表的中间节点
        ListNode pre=null,slow=head,fast=head;
        while (fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }//循环结束后 fast指向链表末尾 slow指向链表中间节点
        pre.next=null;

        //递归分割
        ListNode list1=sortList(head);
        ListNode list2=sortList(slow);

        //2.治 两两合并子数组
        return merge(list1,list2);
    }

    //合并函数
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode l=new ListNode(0),p=l;     //l为合并后的结果链表
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                p.next=list1;
                list1=list1.next;
            }else {
                p.next=list2;
                list2=list2.next;
            }
            p=p.next;
        }
        if (list1==null) p.next=list2;
        if (list2==null) p.next=list1;

        return l.next;  //切记这里返回的是l.next 因为链表的首指针我们初始化的是0
    }
}
public class t148_SortList {
    public static void main(String[] args) {
        t215_KthLargestElement xjh=new t215_KthLargestElement();
        ListNode a1=new ListNode(4);
        ListNode a2=new ListNode(7);
        ListNode a3=new ListNode(1);
        ListNode a4=new ListNode(3);
        ListNode a5=new ListNode(10);
        a1.next=a2;a2.next=a3;a3.next=a4;a4.next=a5;
    }
}
