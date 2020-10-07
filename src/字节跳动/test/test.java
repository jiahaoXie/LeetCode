package 字节跳动.test;

import java.util.Scanner;

/**
 * ccf 图像旋转
 * @author xjh 2018.09.15
 *
 */
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		int[][] a=new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++)
				a[i][j]=sc.nextInt();
		}
		
		for(int j=m-1;j>=0;j--){
			for(int i=0;i<n;i++){				
				    System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

}
