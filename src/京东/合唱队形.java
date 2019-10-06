package 京东;

import java.util.*;

public class 合唱队形 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();// N名学生
        int[] req = new int[N];
        for (int i = 0; i < N; i++) {
            req[i] = sc.nextInt();
        }
        System.out.println(solution(req));
    }

    private static int solution(int[] req) {
        int count = 0;
        List<Help> sortList = new ArrayList<>();
        for (int i = 0; i < req.length; i++) {
            Help help = new Help(req[i], i);
            sortList.add(help);
        }
        Collections.sort(sortList, new Comparator<Help>() {
           @Override
            public int compare(Help h1, Help h2) {
                return h1.getValue() - h2.getValue();//升序
            }
        });
        // 编号最后出现的位置
        int[] arr = new int[sortList.size()];
        for (int i = 0; i < sortList.size(); i++) {
            arr[sortList.get(i).getIndex()] = i;
        }
        List<Integer> list = new ArrayList<>();
        int low = 0, high = 0;
        for (int i = 0; i < arr.length; i++) {
            high = Math.max(high, arr[i]);
            if (i == high) {
                list.add(high - low + 1);
                low = high + 1;
            }
        }
        return list.size();
    }

}

class Help {
    int value;
    int index;

    public Help(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
