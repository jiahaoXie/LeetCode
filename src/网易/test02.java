package 网易;

import java.util.Scanner;
/**
 * 网易春招实习真题 第二题 输入n,k 输出多少个(x,y)可能对
 * x,y满足x y都小于等于n 并且x%y大于等于k
 * @author xjh 2019.03.31 网上答案 有点没看懂？？
 */
public class test02 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();   //nextLong是考虑到题干中n的取值范围
        long k = scan.nextLong();
        long count = 0;
        if (k == 0) {
            System.out.println(n * n);}//k为0的话直接就是n的平方
        else{
            for (long i = k + 1; i <= n; i++) {
                //这里是不是每次把n当x i当y???
                count += (n / i) * (i - k);//找前(n / i )个数里面有几个循环节，每一个节有(i - k)个数
                if (n % i >= k) {
                    count += n % i - k + 1;//剩下的数不足一个循环节，找第(n / i * i + 1 , n)里面有几个数满足题
                }
            }
            System.out.println(count);
        }
    }
}
