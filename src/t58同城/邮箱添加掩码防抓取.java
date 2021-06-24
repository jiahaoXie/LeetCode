package t58同城;

import java.util.Scanner;

public class 邮箱添加掩码防抓取 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int flag = s.indexOf("@");
        String pre = s.substring(0, flag);
        String latter = s.substring(flag);
        char[] c = pre.toCharArray();
        char[] temp = "MASK".toCharArray();
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (i == c.length - 1)
                st.append(c[i]);
            else st.append(c[i] + "" + temp[i % temp.length]);
        }
        System.out.println(st.toString() + latter);

    }
}
