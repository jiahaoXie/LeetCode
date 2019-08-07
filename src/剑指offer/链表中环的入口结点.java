package 剑指offer;

/**
 * @author xjh 2019.04.29
 * 这道题 可通过画图来进行说明，链表头节点到环的入口点举例为x 环的入口点顺时针到快慢指针二者相遇的距离是a 整个环的长度为c
 * 则快慢指针【p1慢是一步 p2快是一次走两步】 首次相遇,p2=x+n*c+a,p1=x+m*c+a;
 * 由p2=2*p1 得x+n*c+a=2*(x+m*c+a) => x=(n-2m-1)c+c-a 这里n-2m-1可能是0
 * 由上述x与c-a二者的等式 可知，这时将p2放在链表头节点，p1 p2每次都只移动一步 p1 p2再相遇时为环的入口节点
 */
public class 链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead==null||pHead.next==null) return null;
        ListNode p1=pHead,p2=pHead;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            if (p1==p2){
                //快慢指针第一次相遇
                p2=pHead;
                while (p1!=p2){
                    p1=p1.next;
                    p2=p2.next;
                }
                if (p1==p2) return p1;
            }
        }
        return null;
    }
}
