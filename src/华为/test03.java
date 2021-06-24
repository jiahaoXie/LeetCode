package 华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<String[]> str = new ArrayList<>();
        String sc = null;
        while (!(sc = in.nextLine()).equals("")) {
//            String sc=in.nextLine().trim();
            String[] tt = sc.split(",");
            str.add(tt);
//            str.add(sc);
        }
        StringBuffer res = new StringBuffer();    //结果字符串

        int i = 0;
        while (!str.isEmpty()) {
//            if (str.get(i).equals("")) break;
            if (str.get(i).length > n - 1) {
                for (int j = 0; j < n; j++) {
                    res.append(str.get(i)[j] + ",");
                }
                String[] temp = new String[str.get(i).length - n + 1];
                int aa = 0;
                for (int tt = n; tt < str.get(i).length; tt++) {
                    temp[aa++] = str.get(i)[tt];
                }
                str.remove(i);
                str.add(temp);
            } else {
                for (int j = 0; j < str.get(i).length; j++) {
                    res.append(str.get(i)[j]);
                }
                res.append(str.get(i));
                str.remove(i);
            }
        }
        String result = res.toString();
//        System.out.println(res);
        for (int k = 0; k < result.length() - 1; k++) {
            System.out.print(result.charAt(k));
        }
    }
}
