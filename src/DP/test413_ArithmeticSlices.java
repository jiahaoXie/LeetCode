package DP;

/**
 * 这道题有好几种解，仔细领会！
 * @author xjh 2019.06.08
 */
public class test413_ArithmeticSlices {
    public static void main(String[] args) {
        test413_ArithmeticSlices xjh=new test413_ArithmeticSlices();
        int[] A={1,2,3,4};
        System.out.println(xjh.numberOfArithmeticSlices2(A));
    }

    //方法1 暴力破解 两层for循环判断 时间复杂度是O(n^2) 空间复杂度是O(1)
    public int numberOfArithmeticSlices(int[] A) {
        int count=0;
        for (int i=0;i<A.length-2;i++){
            int d=A[i+1]-A[i];
            for (int e=i+2;e<A.length;e++){
                if ((A[e]-A[e-1])==d) count++;
                else break;
            }
        }
        return count;
    }

    //方法2 递归解决 时间复杂度是O(n) 空间复杂度是O(n)
    public int sum=0;
    public int numberOfArithmeticSlices2(int[] A) {
        slices(A,0);
        return sum;
    }
    public int slices(int[] A,int i){
        if (i>=A.length-2) return 0;
        int count=0;
        if (A[i]-A[i+1]==A[i+1]-A[i+2]){
            count=1+slices(A,i+1);
            sum+=count;
        }else slices(A,i+1);
        return count;
    }

    //方法3 dp来解 时间复杂度是O(n) 空间复杂度是O(n)
    public int numberOfArithmeticSlices3(int[] A) {
        int[] dp=new int[A.length]; //dp[i]用来表示i位置向前看的最大切片数
        int sum=0;
        for (int i=2;i<A.length;i++){
            if (A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp[i]=1+dp[i-1];    //因为条件判断中二者差相等，那么dp[i-1]位置上的情况 在dp[i]上同样满足
                sum+=dp[i];
            }
        }
        return sum;
    }

}
