package 剑指offer;

/**
 * 循环链表的题目
 * 方法二 方法更加简单
 * @author xjh 2019.04.22
 */
public class 左旋转字符串 {
    static class Node{
        char data;
        Node next;
        Node(char data) {
            this.data = data;
        }
    }

    //方法1 手写一个循环链表 来实现
    public String LeftRotateString(String str,int n) {
        if (str.equals("")) return "";
        char[] s=str.toCharArray();
        Node[] node=new Node[s.length];
        for (int i=0;i<s.length;i++)node[i]=new Node(s[i]);
        for (int i=0;i<s.length;i++){
            if (i==s.length-1){
                node[i].next=node[0];
            }else {
                node[i].next=node[i+1];
            }
        }
        StringBuilder sb=new StringBuilder();
        //结果输出 从指定位置输出
        Node first=node[0];
        int count=1;
        while (count<=n) first=first.next;
        sb.append(first.data);
        count=1;
        while (count!=s.length){
            first=first.next;
            sb.append(first.data);
            count++;
        }
        return sb.toString();
    }

    //方法2 简单 易懂 厉害！！！
    public static String LeftRotateString2(String str,int n) {
        int len = str.length();
        if(len == 0) return "";
        n = n % len;
        str += str;
        return str.substring(n, len+n);
    }

    //方法3 网上的答案 XY变为YX[YX=(X^T Y^T)^T] 在Java中好像不太适用
    public static String LeftRotateString3(String str,int n) {
        int len=str.length();
        if (len==0) return "";
        n=n%len;
        for (int i=0,j=n-1;i<j;i++,j--) swap(str,i,j);
        for (int i=n,j=len-1;i<j;i++,j--) swap(str,i,j);
        for (int i=0,j=len-1;i<j;i++,j--) swap(str,i,j);
        return str;
    }
    public static void swap(String str,int i,int j){
    }

    public static void main(String[] args) {
        String str="abcdefg";
        System.out.println(LeftRotateString2(str,2));
    }
}
