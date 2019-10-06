package 剑指offer;

import java.util.HashSet;

/**
 * @author xjh 2019.04.17
 */
public class 两个链表的第一个公共结点 {
    public ListNode FindFirstComnNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1=pHead1,p2=pHead2;
        HashSet<ListNode> temp=new HashSet<>();
        while (p1!=null){
            temp.add(p1);
            p1=p1.next;
        }
        while (p2!=null){
            if (temp.contains(p2)) return p2;
            p2=p2.next;
        }
        return null;
    }
}
