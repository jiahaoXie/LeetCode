package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * leetcode 406 Queue Reconstruction by Height
 *
 * @author xjh 2019.02.28
 * 这道典型的算法题 有一定的难度 需要考虑同时考虑两个属性 h k
 */
public class t406QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];    //按照h降序 k升序进行排序
            }
        });
        //同理 上面这条语句可缩写为： Arrays.sort(people,(o1,o2)->o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]);
//        for (int i=0;i<people.length;i++){
//            for (int j=0;j<2;j++)
//                System.out.print(people[i][j]+",");
//            System.out.print("  ");
//        }//验证得到输出结果为 7,0,  7,1,  6,1,  5,0,  5,2,  4,4,


        //排好序之后进行插入操作 首先将排序后h最大并且k最小的 放在最前面，，然后选出次最大的 由k值进行插入操作 ，如此循环
//        int[][] res=new int[people.length][2];  //结果数组
//        for (int i=0;i<people.length;i++){
//            int pos=people[i][1];   //k值
//            for (int j=i;j>pos;j--) //当前位置与k值 进行比较
//                res[j]=res[j-1];    //元素后移
//            res[pos]=people[i]; //插入指定位置
//        }
//        return res;

        //一种跟简单的使用方法
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p); //原型：add(int index, E element) 在index位置插入元素element
        }
        return queue.toArray(new int[queue.size()][]);
    }

    public static void main(String[] args) {
        t406QueueReconstruction xjh = new t406QueueReconstruction();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] res = xjh.reconstructQueue(people);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < 2; j++)
                System.out.print(res[i][j] + ",");
            System.out.print("  ");
        }
    }
}
