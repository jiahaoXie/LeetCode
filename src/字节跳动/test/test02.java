package 字节跳动.test;

import java.util.Scanner;

public class test02 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int P = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        //开始M行操作
        for (int i = 0; i < M; i++) {
            String t = sc.next();    //标识 A or B
            String n = sc.next();    //数字
            int num = Integer.parseInt(n);
            if (t.equals("A")) {
                a[num - 1] += 1;
            } else {
                a[num - 1] -= 1;
            }

        }

        //输出结果
        int grade = N;
        for (int i = 0; i < N; i++) {
            if ((P - 1) != i && a[P - 1] >= a[i]) {
                //说明排名上升
                grade--;
            }
        }
        System.out.println(grade);
    }

}
