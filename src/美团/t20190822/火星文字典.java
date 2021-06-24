package 美团.t20190822;

import java.util.ArrayList;
import java.util.Scanner;

public class 火星文字典 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(" ");
        int count = 0;
        for (String tmp : ss) {
            count += tmp.length();    //总共的有效字母
        }
        ArrayList<Character> res = new ArrayList<>();
        int i = 0, k = 0;
        while (true) {
            //首字母排序
            for (String t : ss) {
                if (i < t.length()) {
                    k++;
                    if (i == 0) {
                        if (res.contains(t.charAt(i)) && (res.lastIndexOf(t.charAt(i)) != res.size() - 1)) {
                            System.out.println("invalid");
                            return;
                        } else {
                            if (res.contains(t.charAt(i))) continue;
                            else res.add(t.charAt(i));
                        }
                    } else {

                        if (res.contains(t.charAt(i))) continue;
                        else res.add(t.charAt(i));
                    }
                }
            }
            i++;
            if (k >= count) break;
        }
        for (int j = 0; j < res.size(); j++) {
            System.out.print(res.get(j));
        }
    }
}
