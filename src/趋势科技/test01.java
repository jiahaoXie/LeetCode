package 趋势科技;

import java.util.Scanner;

/**
 * 循环链表的题目
 * 一维数组中的元素 首尾相连 按照一定的规则删除数组中的元素 求出最后一个被删除的元素
 * 例如: 样例输入：0 1 2 3 4 5 6 7 8 9  输出为9
 * 0->1(删除)->2->3->4(删除)->5->6->7->8(删除)->9->0->2->3->5(删除),,如此直到最后一个树被删除
 *
 * @author xjh  2019.04.14
 */
public class test01 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String sc = in.nextLine();
//            if (sc.equals("a")) break;
            String[] s = sc.split(" ");
            Node[] node = new Node[s.length];
            for (int i = 0; i < s.length; i++)
                node[i] = new Node(s[i].charAt(0) - '0');
            for (int i = 0; i < s.length; i++) {
                if (i == s.length - 1) {    //最后一个节点，指针指向头节点
                    node[i].next = node[0];    //node[0]则为循环链表
                } else node[i].next = node[i + 1];
            }

            //删除节点操作
            int interval = 1; //间隔
            Node p = node[0];
            while (p.next != null) {
                int count = interval;
                while (--count > 0 && p.next != null) {
                    p = p.next;
                }
//                if (p.next==null) break;
                if (p.next.next == p.next) break;
                p.next = p.next.next;
                p = p.next;
                interval++;
            }
            System.out.println(p.data);
        }
    }
}
