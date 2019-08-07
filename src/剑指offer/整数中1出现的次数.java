package 剑指offer;

/**
 * 这道题难！！ 需要找到数字中的规律
 * @author xjh 2019.04.15
 */
public class 整数中1出现的次数 {
    public static int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0) return 0;
        int count = 0;
        // 这里是首先推导每一位上的数字规律 然后归纳出数学表达式
        // 个位：1会每隔10出现一次[1,11,21]   归纳为：n/10*1+(n%10!=0?1:0)
        //十位：十位上出现1的情况是10-19，共10个   归纳位：(n/100)*10+(if(n%100>19)10 else if(n%100<10) 0 else n%100-10+1)
        //                                       它等价于：(n/100)*10+min(max(n%100-10+1,0),10)
        //百位：百位上出现1的情况是100-199，共100个    归纳为：(n/1000)*100+min(max(n%1000-100+1,0),i)
        for(long i = 1; i <= n; i *= 10){
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(100));
    }
}
