package 美团;

import java.util.Scanner;

/**
 * 美团第二题 字符串匹配问题
 * @author xjh 2019.04.23
 */
public class 最多匹配 {
    public static int count=0;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String aa=in.nextLine();
        String bb=in.nextLine();
        char[] a=aa.toCharArray();
        char[] b=bb.toCharArray();
        search(a,b);
        kmp(a,a.length,b,b.length);
        System.out.println(count);
    }

    //BF算法 搜索 超时36%
    public static void search(char[] S,char[] T){
        int k = 0;
        while (k<S.length){
            int i=k;
            int j = 0;
            while (j < T.length&&i<S.length) {
                if (S[i] == T[j]||S[i]=='?') {
                    ++i;
                    ++j;
                } else {
                    i = i - j + 1;
                    j = 0;
                }
            }
            if (j == T.length) count++;
            if (i==S.length) break;
            k++;
        }
    }
    //sunday算法
    public static final int ASCII_SIZE=126;
    public static void sunday(char[] a,char[] b) {
        int[] move = new int[ASCII_SIZE];
        //主串参与匹配最末位字符移动到该位需要一定的位数
        /**
         * 定义一个长为ASCII码长度大小的数组move，用于存放存入匹配失败时模式串需要移动的长度。
         * 这里看到，除了模式串b中不存在的字符，移动长度都直接是模式串长度+1；
         * 而模式串b中存在的字符，则需要移动的长度则依次减小。这也很好理解，
         * 因为我们匹配的是模式串首部位置+模式串长度+1位置的字母存在于模式串中的位置，
         * 这个位置越靠后，则整个模式串需要移动的距离就越短
         */
        for (int i = 0; i < ASCII_SIZE; i++) {
            move[i] = b.length + 1;
        }
        for (int i = 0; i < b.length; i++) {
            move[b[i]] = b.length - i;
        }

        int k = 0;
        while (k < a.length) {
            int s = k;    //模式串头部在字符串位置
            int j;      //模式串已经匹配了的长度
            while (s <= a.length - b.length) {
                //到达末尾之前
                j = 0;    //每一次匹配之前初始化为0
                while (a[s + j] == b[j]||a[s+j]=='?') {
                    ++j;
                    if (j == b.length){
                        count++;
                        break;
                    }
                }
                s += move[a[s + b.length]];
            }
            k++;
        }
    }

    //KMP算法
    public static void kmp(char[] a,int n,char[] b,int m) {
        //a,b分别是主串和模式串；n,m分別是主串和模式串的长度
        int[] next = getNexts(b, m);

        int k = 0,i=0;
        while (k < a.length) {

            int j = 0;
            for (i = k; i < n; i++) {
                while (j<m&&j > 0 && a[i] != b[j]) { //一直找到主串和模式串中不匹配的坏字符 也就是a[i]和b[j]
                    j = next[j - 1] + 1;
                }
                if (j<m&&(a[i] == b[j]||a[i]=='?')) ++j;
                if (j == m) count++;     //找到匹配模式串的了
            }
            if (i==n) break;
            k++;
        }
    }

    /**
     * 构建next数组
     */
    public static int[] getNexts(char[] b,int m){
        //b表示模式串，m表示模式串的长度
        int[] next=new int[m];
        next[0]=-1;
        int k=-1;
        for (int i=1;i<m;i++){
            while (k!=-1&&b[k+1]!=b[i]){
                k=next[k];
            }
            if (b[k+1]==b[i]) ++k;
            next[i]=k;
        }
//        for (int i=0;i<next.length;i++)
//            System.out.print(next[i]+" ");
//        System.out.println();
        return next;
    }
}
