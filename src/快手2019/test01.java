package 快手2019;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题干要求：求a/b的小数表现形式。
 * 如果a可以整除b则不需要小数点。如果是有限小数，则可以直接输出。如果是无限循环小数，则需要把小数循环的部分用"()"括起来。
 */
public class test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt();
        if (a % b == 0) System.out.println(a / b);    //整数直接输出
        else {
            String s = "";
            int shang = a / b;
            s += shang + ".";
            int yushu = a % b;
            Map<Integer, Integer> map = new HashMap<>();   //保存循环小数
            while (yushu != 0) {
                if (map.containsKey(yushu)) {    //出现循环小数
                    s = s.substring(0, map.get(yushu)) + "(" + s.substring(map.get(yushu)) + ")";    //重复的部分用括号括起来
                    System.out.println(s);
                    return;
                }
                map.put(yushu, s.length());
                yushu *= 10;
                shang = yushu / b;
                yushu = yushu % b;
                s += shang;
            }
            System.out.println(s);
        }
    }
}
