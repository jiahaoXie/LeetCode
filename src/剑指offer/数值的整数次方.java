package 剑指offer;

/**
 * @author xjh 2019.04.07
 * 要考虑expoent的负数情况
 */
public class 数值的整数次方 {
    public double Power(double base, int exponent) {
        if (exponent==0) return 1;
        double sum=1;
        boolean flag=exponent>0?true:false;
        for (int i=1;i<=Math.abs(exponent);i++){
            sum=sum*base;
        }
        if (!flag) return 1/sum;
        return sum;
    }
}
