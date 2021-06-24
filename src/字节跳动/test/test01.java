package 字节跳动.test;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] str = s.toCharArray();
        int[] data = new int[6];
        for (int i = 0; i < str.length; i++) {
            data[i] = str[i] - '0';
        }
//		for(int j:data){
//			System.out.print(j+"~");
//		}
//		System.out.println(data[5]);
//		String[] ss=s.split("");
//		int[] data=new int[6];
//		for(int i=0;i<s.length();i++){
//			data[i]=Integer.parseInt(ss[i+1]);
//		}		
        int number = 0;
        int sum = Math.abs(data[3] + data[4] + data[5] - (data[0] + data[1] + data[2]));
        if (sum <= 9 && sum > 0) {
            number += 1;
        } else if (sum > 9 && sum <= 18) {
            number += 2;
        } else if (sum > 18) {
            number += 3;
        }
        System.out.println(number);
    }

}
