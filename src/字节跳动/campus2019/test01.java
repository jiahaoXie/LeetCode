package 字节跳动.campus2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class test01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Map<Integer,List<Integer>> map=new HashMap<>();
		for(int i=1;i<=n;i++){
			int num=sc.nextInt();			
			List<Integer> list=new ArrayList<>();
			list.add(num);
			map.put(i, list);			
		}
		System.out.println("---------------");
		System.out.println(map);				
	}
}
