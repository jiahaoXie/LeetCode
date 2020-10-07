package 京东;

import javafx.util.Pair;

import java.util.*;

public class test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            if (0 == in.nextInt()) break;
            int n = in.nextInt(), w = in.nextInt(), h = in.nextInt();
            int cardSum = w * h;
            Map<Integer, int[]> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                int wt = in.nextInt(), ht = in.nextInt();
                int sum = wt * ht;  //信封乘积
                int[] temp = {wt, ht, sum};
                map.put(i, temp);
            }
//        System.out.println(map);
            //接下来map根据value升序排列
            List<Map.Entry<Integer, int[]>> list = new ArrayList<Map.Entry<Integer, int[]>>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, int[]>>() {
                //升序排序
                public int compare(Map.Entry<Integer, int[]> o1, Map.Entry<Integer, int[]> o2) {
                    int[] t1 = o1.getValue();
                    int[] t2 = o2.getValue();
                    if (t1[2] > t2[2]) return 1;
                    if (t1[2] < t2[2]) return -1;
                    return 0;
                }
            });
//        System.out.println(list);
            int count = 0;
            ArrayList<Integer> num = new ArrayList<>();
            for (Map.Entry<Integer, int[]> m : list) {
                int[] t = m.getValue();
                if (cardSum < t[2]) {
                    count++;
                    num.add(m.getKey());
                    cardSum = t[2];
                }
            }
            System.out.println(count);
            if (num.size() == 0) System.out.println(0);
            else {
                for (int i : num)
                    System.out.print(i + " ");

            }
            System.out.println();
        }
    }
}
