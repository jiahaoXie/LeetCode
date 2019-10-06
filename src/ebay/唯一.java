package ebay;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 唯一 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for (int i=0;i<a.length;i++) a[i]=in.nextInt();
        int m=in.nextInt();
        while (m-->0){
            int left=in.nextInt(),right=in.nextInt();
            int count=0;
            HashMap<Integer,Integer> map=new HashMap<>();
            for (int i=left-1;i<=right-1;i++){
                if (!map.containsKey(a[i])){
                    map.put(a[i],1);
                }else map.put(a[i],map.get(a[i])+1);
            }
            for(Map.Entry<Integer,Integer> t: map.entrySet()){
                if (t.getValue()==1) count++;
            }
            System.out.println(count);
        }
    }
}
