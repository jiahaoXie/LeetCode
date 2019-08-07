package 剑指offer;

import java.util.Arrays;

/**
 * 注意 不能使用除法
 * @author xjh 2019.04.28
 */
public class 构建乘积数组 {
    // 方法1 两层for循环 时间复杂度是O(n^2)
    public int[] multiply(int[] A){
        int n=A.length;
        int[] res=new int[n];
        Arrays.fill(res,1);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i==j) continue;
                res[i]*=A[j];
            }
        }
        return res;
    }

    //方法2 剑指书上的答案 计算上三角 和下三角的同行乘积 时间开销为O(n)
    //这个答案 很妙！！
    public int[] multiply2(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0 ){
            B[0] = 1;
            //计算下三角连乘
            for(int i = 1; i < length; i++){
                B[i] = B[i-1] * A[i-1];
            }
            int temp = 1;
            //计算上三角
            for(int j = length-2; j >= 0; j--){
                temp *= A[j+1];
                B[j] *= temp;
            }
        }
        return B;
    }
}
