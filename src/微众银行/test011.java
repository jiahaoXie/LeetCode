package 微众银行;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test011 {
    public static void main(String[] args) {
        List list=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
//        System.out.print("请输入人数：");
        int n=scanner.nextInt();
//        System.out.print("请输入报到m的出列（m）：");
        int m=scanner.nextInt();
        //初始化list列表
        for (int i = 1; i <=n; i++) {
            list.add(i);
        }
//        numberOff(list, m);
        while (list.size()>1) {
            for (int i = 0; i < m-1; i++) {/**
             * 
             * remove(int index)用来清除集合中制定索引位置的对象，后面的元素自动全部向前移动
             * void add(int index, E element) index - 要在其中插入指定元素处的索引    element - 要插入的元素
             * index可省略 ，但是添加元素的时候，需要添加到已有数据的后面*/
                list.add(list.remove(0));
            }
            System.out.print(list.get(0)+" ");
            list.remove(0);

        }
        System.out.println();
        System.out.println(list.get(0));
    }

//    public static void numberOff(List list,int m) {
//        while (list.size()>1) {
//            for (int i = 0; i < m-1; i++) {/**
// * 
// * remove(int index)用来清除集合中制定索引位置的对象，后面的元素自动全部向前移动
// * void add(int index, E element) index - 要在其中插入指定元素处的索引    element - 要插入的元素
// * index可省略 ，但是添加元素的时候，需要添加到已有数据的后面*/
//                list.add(list.remove(0));
//
//            }
//            System.out.print(list.get(0)+" ");
//            list.remove(0);
//
//        }
//        System.out.println();
//        System.out.println(list.get(0));
//    }
}
