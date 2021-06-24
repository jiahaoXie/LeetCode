package 京东;

import java.util.*;

public class test011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            int[][] temps = new int[num][4];
            int nums = 0;
            for (int i = 0; i < num; i++) {
                int tempWidth = scanner.nextInt();
                int tempHigh = scanner.nextInt();
                if (tempWidth > w && tempHigh > h) {
                    temps[nums][0] = tempWidth;
                    temps[nums][1] = tempHigh;
                    temps[nums][2] = i + 1;
                    temps[nums][3] = temps[nums][0] * temps[nums][1];
                    nums++;
                }
            }
            findTemp(Arrays.copyOfRange(temps, 0, nums), nums, w, h);
        }
    }

    public static void findTemp(int[][] temps, int num, int w, int h) {
        //首先对所有的数据进行排序，以面积的形式进行排序
        Arrays.sort(temps, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[3] > o2[3]) return 1;
                if (o1[3] < o2[3]) return -1;
                return 0;
            }
        });
        List<List<int[]>> resultList = new ArrayList<>();
        List<int[]> headList = new ArrayList<>();
        headList.add(new int[]{w, h, 1});
        resultList.add(headList);
        for (int i = 1; i <= num; i++) {
            int levelNow = 0;
            for (int j = i - 1; j >= 0; j--) {
                List<int[]> list = resultList.get(j);
                int oldLevel = list.size();
                if (oldLevel < levelNow - 1) break;
                int[] oldTop = list.get(oldLevel - 1);
                if (oldTop[0] < temps[i - 1][0] && oldTop[1] < temps[i - 1][1]) {
                    List<int[]> tempList = new ArrayList<>();
                    tempList.addAll(list);
                    tempList.add(temps[i - 1]);
                    //更新resultList，保存最优值
                    if (resultList.size() == i + 1) resultList.remove(i);
                    resultList.add(tempList);
                    levelNow = oldLevel + 1;
                }
            }
        }
        System.out.println(resultList.get(num).size() - 1);
        for (int i = 1; i < resultList.get(num).size(); i++) {
            System.out.print(resultList.get(num).get(i)[2] + " ");
        }
        System.out.println();
    }
}
