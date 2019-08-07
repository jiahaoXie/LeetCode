package 剑指offer;

/**
 * 求1+2+3+...+n
 * @author xjh 2019.04.26
 * 利用逻辑与的短路特性实现递归终止
 */
public class 求和1到n {
    public static int Sum_Solution(int n) {
        int m=n;
        boolean flag=(m>0)&&(m+=Sum_Solution(m-1))>0;
        //m为0时，(m>0)&&(m+=Sum_Solution(m-1))>0 逻辑与执行左边就判定假不再执行右边了
        //m不为0时，才会递归求和 n+(n-1)+(n-2)+...+1
        return m;
    }

    public static void main(String[] args) {
        System.out.println(Sum_Solution(100));
    }
}
