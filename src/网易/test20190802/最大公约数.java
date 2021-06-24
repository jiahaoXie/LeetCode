package 网易.test20190802;

import java.math.BigInteger;
import java.util.Scanner;

public class 最大公约数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger aa = in.nextBigInteger();
        BigInteger bb = in.nextBigInteger();
//        long a=in.nextLong();
//        long b=in.nextLong();
        BigInteger res = getGD(aa, bb);
        System.out.println(res);
    }

    public static BigInteger getGD(BigInteger a, BigInteger b) {
        BigInteger zero = new BigInteger("0");
        if (a.compareTo(zero) < 0 || b.compareTo(zero) < 0) return new BigInteger("-1");
//        if (a<0||b<0) return -1;
        if (b.equals(zero)) return a;
        return getGD(b, a.remainder(b));
    }
}
