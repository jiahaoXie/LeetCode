package 微众银行.test20190919;

import java.math.BigDecimal;
import java.util.Scanner;

public class 末尾的数 {
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        BigDecimal n = new BigDecimal(in.nextInt());
        int result = 1;
        BigDecimal t = new BigDecimal(result);
        int temp = 1;
        BigDecimal big = new BigDecimal(temp);
        for (; big.compareTo(n) <= 0; ) {
            t = t.multiply(big);
            big = big.add(new BigDecimal(1));
        }
        String str = String.valueOf(t);
        for (int index = str.length() - 1; index >= 0; index--) {
            if (str.charAt(index) == '0') {
                continue;
            } else {
                System.out.println(str.charAt(index));
                break;
            }
        }
    }
}
