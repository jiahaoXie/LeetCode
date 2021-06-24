package t58同城;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 用大数类BigInteger来处理
 */
public class 十进制转换为27进制 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '\'',
                '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '{', '}',
                '\\', '<', '>', '?'};
        while (sc.hasNext()) {
            BigInteger n = sc.nextBigInteger();
            String res = "";
            do {
                int x = n.mod(BigInteger.valueOf(27)).intValue();
                res = c[x] + res;
                n = n.divide(BigInteger.valueOf(27));
            } while (n != BigInteger.ZERO);
            System.out.println(res);
        }
    }
}
