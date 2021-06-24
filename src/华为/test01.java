package 华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 华为春招实习笔试第一题 修改版本
 *
 * @author xjh 2019.04.04
 */
public class test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();  //接收空行
        List<String> list = new ArrayList<>();
        String sc = null;
        while (in.hasNextLine()) {
            sc = in.nextLine();
            if (sc.equals("a")) break;  //本地测试加这句是为了调试 提交时不加
            list.add(sc);
        }
        //计算多行输入数组的最大长度
        int max = 0;
        for (int m = 0; m < list.size(); m++) {
            String[] str = list.get(m).split(",");
            max = Math.max(max, str.length);
        }
//        System.out.println("max="+max);
        int ll = 0;   //表示一行数组截取的次数
        StringBuffer sb = new StringBuffer();
        while (ll < max) { //这个代码最关键的地方在于这个while循环
            for (int i = 0; i < list.size(); i++) {
                String[] str = list.get(i).split(",");
                for (int j = 0; j < n; j++) {
                    if (ll + j < str.length) sb.append(str[ll + j] + ",");
                    else break;
                }
                if (i == list.size() - 1) ll += n;    //一次遍历完 更新ll 然后又从list.get(0) 开始执行
            }
        }
        //输出
        String res = sb.toString();
        for (int i = 0; i < res.length() - 1; i++) {
            System.out.print(res.charAt(i));
        }
    }
}