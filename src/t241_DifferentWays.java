import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * leetcode 241. Different Ways to Add Parentheses
 *
 * @author xjh 2019.03.13
 * 这是一道很经典的分治算法题 审题时不要考虑加括号 而是如何运用分治的思想 以及用递归实现
 * 这道题 很有难度
 */
public class t241_DifferentWays {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = compute(input);
        //做一个排序   这道题提交的时候 leetcode不用做排序 但自身应该知道有这种方法
//        Collections.sort(res, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
        return res;
    }

    public List<Integer> compute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                //遇到运算符 就递归拆解数字
                List<Integer> left = compute(input.substring(0, i));
                List<Integer> right = compute(input.substring(i + 1));
                for (Integer l : left) {
                    for (Integer r : right) {
                        if (c == '+') res.add(l + r);
                        else if (c == '-') res.add(l - r);
                        else res.add(l * r);
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }

    public static void main(String[] args) {
//        t241_DifferentWays xjh=new t241_DifferentWays();
//        String input="2*3-4*5";
//        List<Integer> res=xjh.diffWaysToCompute(input);
//        for (int i:res){
//            System.out.print(i+",");
//        }

        ArrayList<Integer> list = new ArrayList();
        list.add(90);
        list.add(68);
        list.add(168);
        list.add(242);
        list.add(317);
        list.add(105);
        // 字符串排序
        Collections.sort(list);
        System.out.println(list.toString());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;   //升序
            }
        });
        System.out.println(list.toString());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;   //升序
            }
        });
        System.out.println(list.toString());
    }
}
