package 字节跳动;

import java.util.ArrayList;
import java.util.Scanner;

public class test2 {
    public static long sum;
    public static int l,r;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt(),q=in.nextInt();
        in.nextLine();
        String s=in.nextLine();
        String[] ss=s.split(" ");
        while (m-->0){
            ArrayList<String> list=new ArrayList<>();
            for (int i=0;i<ss.length;i++) list.add(ss[i]);
            l=in.nextInt();r=in.nextInt();
            sum=0;
            boolean flag=false;
            for (int i=l-1;i<=r-1;){
                if (list.get(i).equals(">")) {
                    list.remove(i);
                }
                else if (list.get(i).equals("<")) {
                    list.remove(i);
                    right(list,i);
                    System.out.println(sum);
                    flag=true;
                    break;
                }
                else {
                    sum+=Integer.valueOf(list.get(i));
                    int temp=Integer.valueOf(list.get(i))-1;
                    list.set(i,String.valueOf(temp));
                    i++;
                }
            }
            if (flag==false)  System.out.println(sum);
        }
    }
    public static void right(ArrayList<String> list,int i){
        for (int j=i-1;j>=l-1;j--){
            sum+=Integer.valueOf(list.get(j));
            int temp=Integer.valueOf(list.get(j))-1;
            list.set(j,String.valueOf(temp));
        }
    }
}
