package 剑指offer_0;

import java.util.ArrayList;

/**
 * 剑指offer
 * 01判断二维数组中是否存在某个特定的数值
 * 02 替换空格
 * 03 按链表值从尾到头返回一个ArrayList
 *
 * @author xjh 2019.04.02
 */
public class T01_03 {
    //因为数组是有序的 考虑二分查找 这道题的时间复杂度事O(mlogn)
    public boolean Find(int target, int[][] array) {
        int m = array.length, n = array[0].length;
        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (array[i][mid] == target) return true;
                else if (array[i][mid] < target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }

    //还有一种方法更加简单
    //充分利用数组中元素的规律，每一行从左到右递增，每一列从上到下递增
    //这里我么选取左下角的元素来作为参考元素
    public boolean Find2(int target, int[][] array) {
        int row = array.length - 1, col = 0;
        while (row >= 0 && col <= array[0].length - 1) {
            if (target == array[row][col]) return true;
            else if (target > array[row][col]) col++;
            else row--;
        }
        return false;
    }

    public String replaceSpace(StringBuffer str) {
        //1.直接调用String中的replaceAll方法 简单有效
//        String temp=str.toString();
//        return temp.replaceAll(" ","%20");

        //2. 再次运用一个StringBuffer进行字符替换
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < str.toString().length(); i++) {
            char b = str.charAt(i);
            if (String.valueOf(b).equals(" ")) {
                out.append("%20");
            } else {
                out.append(b);
            }
        }
        return out.toString();
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //方法1 链表反转 然后顺序输出节点值
        //1.链表反转
//        ListNode head = null;        //单链表反转之后 新链表的头节点 （也就是原链表的尾节点）
//        ListNode previousNode = null;    //先前节点指针
//        ListNode currentNode = listNode;        //当前节点指针
//        while (currentNode != null) {    //非空链表
//            ListNode nextNode = currentNode.next;
//            if (nextNode == null) {    //以到达最后一个节点
//                head = currentNode;
//            }
//            currentNode.next = previousNode;    //指向前面一个节点（头节点则指向null）
//            previousNode = currentNode;
//            currentNode = nextNode;    //currentNode指向原来链表的下一个节点
//        }
//        //2. 顺序将其存入Arraylist中
//        while (head!=null){
//            res.add(head.val);
//            head=head.next;
//        }
//        return res;

        //方法2 网上大佬的做法 完美的递归场景 三行解决
        if (listNode != null) {
            this.printListFromTailToHead(listNode.next);
            res.add(listNode.val);
        }
        return res;
    }

}
