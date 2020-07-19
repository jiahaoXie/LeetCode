package 百度;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author xjh 2020.3.14
 * 发放几个月的工资
 */
public class 支付工资 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(); int m=in.nextInt();
        int sum=0;
        List<Integer> key=new ArrayList<>();
        List<Integer> value=new ArrayList<>();
        while (n-->0){
            int k=in.nextInt(); int v=in.nextInt();
            if (k>=m){
                sum+=v;
            }else {
                key.add(k); value.add(v);
            }
        }
        List<Integer> sort=new ArrayList<>();
        sort.addAll(key);
        Collections.sort(sort);
        for (int i=0,j=sort.size()-1;i<j;i++){
            if (sort.get(i)+sort.get(j)>=m){
                int t1=key.indexOf(sort.get(i));
                int t2=key.indexOf(sort.get(j));
                if (value.get(t2)==0){
                    j--;
                    continue;
                }
                if (value.get(t1)<=value.get(t2)){
                    sum+=value.get(t1);
                    value.set(t2,value.get(t2)-value.get(t1));
                    value.set(t1,0);
                }else{
                    sum+=value.get(t2);
                    value.set(t1,value.get(t1)-value.get(t2));
                    value.set(t2,0);
                }
            }
        }
        for(int i=0;i<value.size()-1;i++){
            if (value.get(i)*key.get(i)>=m){
                sum+=value.get(i)*key.get(i)/m;
            }
        }
        System.out.println(sum);
    }
}
