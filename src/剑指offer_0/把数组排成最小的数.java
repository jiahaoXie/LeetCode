package 剑指offer_0;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xjh 2019.04.16
 */
public class 把数组排成最小的数 {
    //方法1 自定义比较器函数 数值拼接后 进行两两比较
    public static String PrintMinNumber(int[] numbers) {
        String str = "";
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int a = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int b = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (a > b) {   //交换 使小的数放在前面
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) sb.append(numbers[i]);
        return sb.toString();
//        for (int i=0;i<numbers.length;i++)
//            str+=String.valueOf(numbers[i]);
//        return str;
    }

    //方法2 先把整形数组转换成为String数组 然后将String数组排序，最后将排序好的字符串数组拼接
    //时间复杂度低一些
    public static String PrintMinNumber2(int[] numbers) {
        if (numbers.length == 0) return "";
        int n = numbers.length;
        String[] str = new String[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++)
            str[i] = String.valueOf(numbers[i]);

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);    //升序排序
            }
        });
        for (String s : str)
            sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] number = {3, 32, 321};
        System.out.println(PrintMinNumber2(number));
    }
}
