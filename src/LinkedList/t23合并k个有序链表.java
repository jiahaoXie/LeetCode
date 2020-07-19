package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class t23合并k个有序链表 {
    //方法1 利用小根堆首先存储k个链表的头节点，自动排好序后 将最小的元素去除加入结果链表中，
    // 然后将取出链表的下一个元素加入小根堆中，下次依旧做同样的操作。以此类推，直到堆中没有元素
    // 时间复杂度是O(nlogk) 空间复杂度为O(k),因为创建了一个额外的大小为k的小根堆
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }

    //采用归并的算法思想 分而治之
    //时间复杂度分析：k个链表配对并将同一对中的链表合并，k k/2 k/4 ...直到只有一个链表
    // 每一次配对几乎全部n个节点，重复这一过程log2k次
    //时间复杂度为O(nlogk) 空间复杂度为O(1) 因为是链表归并 所以没有申请额外的存储空间
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
