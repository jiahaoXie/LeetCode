package 腾讯.t20190901;

import java.util.*;

/**
 * @author xjh 2019.09.01
 */
class Point{
    int a;
    int b;
    int index;
    Point(int a,int b,int index){
        this.a=a;
        this.b=b;
        this.index=index;
    }
}
public class 排队 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<Point> p=new ArrayList<>(n);
        for (int i=0;i<n;i++){
            p.add(new Point(in.nextInt(),in.nextInt(),i));
        }
        int sum=0;
        sort(p);
        for (int i=0;i<p.size();i++){
            if (i==p.get(i).index){
                sum+=p.get(i).a*(i)+p.get(i).b*(n-i-1);
            }else sum+=p.get(i).a*(i)+p.get(i).b*(n-i-1);
        }
        System.out.println(sum);
    }
    public static void sort(ArrayList<Point> p) {
        if (p.size()==0) return;
//        Collections.sort(p,(x,y)->(x.a==y.a)?x.b-y.b:y.a-x.a);
        Collections.sort(p, new Comparator<Point>() {
            @Override
            public int compare(Point x, Point y) {
                return (x.a==y.a)?x.b-y.b:y.a-x.a;
            }
        });
    }
}
