package 滴滴;


import java.util.Scanner;

public class 找出最长的相同字符串并输出 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int count = 1;
        char cur = input.charAt(0);
        int temp = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                temp++;
            } else {
                if (temp > count) {
                    count = temp;
                    temp = 1;
                    cur = input.charAt(i - 1);
                }
                temp = 1;
            }
        }
        if (temp > count) {
            count = temp;
            temp = 1;
            cur = input.charAt(input.length() - 1);
        }

        String res = "";
        for (int i = 0; i < count; i++) {
            res += cur;
        }
        System.out.println(res);
    }
}
