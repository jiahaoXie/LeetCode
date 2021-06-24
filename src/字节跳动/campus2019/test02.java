package 字节跳动.campus2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test02 {
    //	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc=new Scanner(System.in);
//		int n=sc.nextInt();
//		int count=1;
//		List<Integer> list=new ArrayList<>();
//		for(int i=1;i<=n;i++){
//			count=count*10;	//得到一共有多少个数与1000000000000007做除法
//		}
//		for(int j=1;j<count;j++){
//			int model=1000000007%j;
//			if(list.contains(model)){
//				continue;
//			}else{
//				list.add(model);
//			}
//		}
//		System.out.println(list.size()+2);
//	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //num_1为合法标识符
        long num_1 = (long) Math.pow(10, n);
        //带括号的合法表达式
        long num_2 = 0;
        if (n > 2) {
            num_2 = (long) Math.pow(10, n - 2);
        }
        //带+ —表达式
        long num_3 = 0;
        for (int i = 1; i < n - 1; i++) {
            int x = (int) Math.pow(10, i);
            int y = (int) Math.pow(10, n - 1 - i);
            num_3 = num_3 + (x * y);
        }
        num_3 = 4 * num_3;
        System.out.println((num_1 + num_2 + num_3) % 1000000007);
    }
}
