package vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 报数 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static String solution(int[] input) {
        int n = input[0], m = input[1];
        if (n == 1) return String.valueOf(n);
        int[] num = new int[n];
        for (int i = 0; i < n; i++) num[i] = i + 1;
        StringBuilder str = new StringBuilder();
        int i = -1, count = n, current = 0;    //i=-1表示当前下标未删除的点   count表示未删除的个数和  current表示当前的报数
        while (count > 0) {//循环跳出时最后一个数 也设置为-1了 结果就是最后一个值为-1的下标
            i++;    //指向上一个删除值的下一个数值
            if (i >= n) i = 0;  //构成环
            if (num[i] == -1) continue; //跳过已删除的值
            current++;
            if (current == m) {
                str.append(num[i] + " ");
                num[i] = -1;
                count--;
                current = 0;
            }
        }
        return str.toString();
    }
}
