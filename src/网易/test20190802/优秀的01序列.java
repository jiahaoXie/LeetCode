package 网易.test20190802;

import java.util.Scanner;

public class 优秀的01序列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        while (T-- > 0) {
            String s = in.nextLine();
            String t = in.nextLine();
            if (s.equals(t) || s.equals(rev(t))) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static String rev(String t) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            if ((t.charAt(i) - '1') == 0) str.append('0');
            else str.append('1');
        }
        String res = str.toString();
        if (res.charAt(0) != '0') return res;
        else {
            int i = 0;
            while (res.charAt(i++) == '0') i++;
            return res.substring(i - 1);
        }
    }
}
