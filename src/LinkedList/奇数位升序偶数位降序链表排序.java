package LinkedList;

/**
 * 头条面试题：一个链表，奇数位升序偶数位降序，让链表变成升序的。
 * 思路：
 *  首先根据奇数位和偶数位拆分成两个链表。
    然后对偶数链表进行反转。
    最后将两个有序链表进行合并。
 * @author xjh 2019.09.29
 */
public class 奇数位升序偶数位降序链表排序 {
    public static ListNode head1 = null;
    public static ListNode head2 = null;
    /**
     * 根据奇数位和偶数位拆分成两个链表
     * @param head
     */
    public static void getLists(ListNode head){
        ListNode cur1 = null;
        ListNode cur2 = null;
        int count = 1;//用来计数
        while(head != null){
            if(count % 2 == 1){
                if(cur1 != null){
                    cur1.next = head;
                    cur1 = cur1.next;
                }else{
                    cur1 = head;
                    head1 = cur1;
                }
            }else{
                if(cur2 != null){
                    cur2.next = head;
                    cur2 = cur2.next;
                }else{
                    cur2 = head;
                    head2 = cur2;
                }
            }
            head = head.next;
            count++;
        }
        //跳出循环，要让最后两个末尾元素的下一个都指向null
        cur1.next = null;
        cur2.next = null;
    }

    /**
     * 反转链表
     */
    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 两个有序链表合并
     */
    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        if (head1.val < head2.val) {
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLists(head1,head2.next);
            return head2;
        }
    }
}
