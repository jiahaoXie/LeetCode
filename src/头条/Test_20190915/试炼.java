package 头条.Test_20190915;

import java.util.LinkedList;
import java.util.Scanner;

public class 试炼 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        LinkedList<Integer> list=new LinkedList<>();
        for (int i=0;i<n;i++) list.add(in.nextInt());
        int left=0,right=list.size()-1;
        int sum=0;
        int flag=0;
        while (!list.isEmpty()){
            if (list.get(left)<list.get(right)){
                if (flag%2==0){
                    sum+=list.get(right);
                    list.remove(right);
                }else {
                    list.remove(right);
                }
                right--;
            }else if (list.get(left)>list.get(right)){
                if (flag%2==0){
                    sum+=list.get(left);
                    list.remove(left);
                }else {
                    list.remove(left);
                }
                right--;
            }else {
                if (left+1<list.size()&&right-1>=0){
                    if (list.get(left+1)>list.get(right-1)){
                        if (flag%2==0){
                            sum+=list.get(right);
                            list.remove(right);
                        }else list.remove(right);
                        right--;
                    }else if(list.get(left+1)<list.get(right-1)){
                        if (flag%2==0){
                            sum+=list.get(left);
                            list.remove(left);
                        }else list.remove(left);
                        right--;
                    }else {
                        if (flag%2==0){
                            sum+=list.get(left);
                            list.remove(left);
                        }else list.remove(left);
                        right--;
                    }
                }else {
                    if (flag%2==0){
                        sum+=list.get(left);
                        list.remove(left);
                    }else list.remove(left);
                    right--;
                }
            }
            flag++;
        }
        System.out.println(sum);
    }
}
