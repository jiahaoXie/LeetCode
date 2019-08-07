package Tree;


/**
 * 有序单链表中的元素转换为一颗平衡的BST
 * @author xjh 2019.05.26
 * 在108题的基础上 扩展，其实就是多了一次找链表中间节点的步骤[快慢指针法]
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class t109_ConvertSortedListBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return new TreeNode(head.val); //没有下一个节点的边界条件

        ListNode premid=middleNode(head);
        ListNode mid=premid.next;
        premid.next=null;   //链表切断 一分为二
        TreeNode root=new TreeNode(mid.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(mid.next);
        return  root;
    }

    public static ListNode middleNode(ListNode p) {
        if (p == null)
            return null;
        ListNode a = p;
        ListNode b = p;
        ListNode pre=null;
        while (a != null && a.next != null) {
            //这里利用快慢两个指针 主要为了让考虑如果链表长度特别大时，单一指针节点往后遍历时间复杂度高
            pre=b;
            a = a.next.next;
            b = b.next;
        }
        return pre;    //b就是链表中间节点 pre是中间节点的前继节点
    }
}
