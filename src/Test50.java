public class Test50 {
    public double myPow(double x, int n) {
        //1.暴力解决 时间复杂度位O(n)
//        if(n<0) n=-n;
//        if(n==0) return 1;
//        if(n==1) return x;
//        for (int i=0;i<n;i++)
//            x*=x;

        //2.利用递归分治的思想 一分为2 时间复杂度是O(logn)
        double result;
        if(n<0) return 1/myPow(x,-n);
        if(n==0) return 1;
        if(n==1) return x;
        if(n%2==1)
            result=x*myPow(x*x,n/2);  //如果位奇数 则拿出一个x后 对半递归
        else result=myPow(x*x,n/2);
        return result;
    }
}
