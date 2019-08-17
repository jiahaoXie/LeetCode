package 科大讯飞;

import java.util.Scanner;

public class test22 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String tmp=in.nextLine();
        if (tmp==null||tmp.trim().length()==0){
            System.out.println(-1);
            return;
        }
        tmp=tmp.substring(1,tmp.length()-1);
        if (tmp==null||tmp.trim().length()==0){
            System.out.println(-1);
            return;
        }
        String[] split=tmp.split(",");
        int[] a=new int[split.length+1];
        for (int i=1;i<a.length;i++){
            a[i]=Integer.valueOf(split[i-1]);
        }
        System.out.println(binarySearch(a,19,1,a.length-1));
    }
    public static int binarySearch(int[] a,int target,int l,int r){
        if (l>r) return -1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (target==a[mid]){
                return mid;
            }else if (target>a[mid]) l=mid+1;
            else r=mid-1;
        }
        return 0;
    }
}
