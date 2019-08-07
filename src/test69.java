/**
 * leetcode 69 Sqrt(x)
 * @author xjh 2018.12.25
 */
public class test69 {
    public static int mySqrt(int x) {
        //1.直接调用Math库中的sqrt方法 提交需要26ms
//        double n=Math.sqrt(x);
//        return (int)n;

        //2.利用二分查找的方法
        if(x==0||x==1) return x;
        int low=1,high=x,result=0;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(mid==x/mid) return mid;
            else if(mid<x/mid){
                low=mid+1;
                result=mid; //考虑到x的平方根很大可能是double 这里输出的是int 所以输出值极大可能为m^2<=x
            }
            else high=mid-1;
        }
        return result;

        //3.利用牛顿迭代法的公式
//        int r=x;
//        while (r*r>x)
//            r=(r+x/r)/2;
//        return r;
    }

    public static void main(String[] args) {
        int s=mySqrt(8);
        System.out.println(s);
    }
}
