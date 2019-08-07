package 剑指offer;

import java.util.Arrays;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @author xjh 2019.04.18
 */
public class 数组中只出现一次的数字 {
    //方法1 先排序 然后for循环一次遍历
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);
        for (int i=0;i<array.length;){
            if (i==0){
                if (array[i]!=array[i+1]) num1[0]=array[i];
            }
            else if (i==array.length-1){
                if (array[i]!=array[i-1]) num2[0]=array[i];
            }
            else if(array[i]!=array[i-1]&&array[i]!=array[i+1]){
                if (num1[0]==0) num1[0]=array[i];
                else num2[0]=array[i];
            }
            i++;
        }
    }

    // 方法2，(网上答案)利用位运算异或的性质：两个数字相同 异或为0 一个数和0异或还是其本身
    //当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，后的结果肯定是那两个只出现一次的数字异或
    // 的结果，因为成对儿出现的都抵消了。
    //这种位运算 有点难想到
    public static void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        int length = array.length;
        if(length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for(int i = 0; i < length; ++i){
            bitResult ^= array[i];  //异或操作
        }
        //假设数组attay中只有a b两个数据出现过一次，这里bitResult的最后结果就是a b异或的结果。
        // bitResult二进制中的1，表示a b的不同的位
        //findFirst1 找到结果中的第一个1所在的位数【假如是第4位】
        //然后根据第四位是否为1 分为；两组 每组例有一个只出现一次的数字
        int index = findFirst1(bitResult);
        for(int i = 0; i < length; ++i){
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    private static int findFirst1(int bitResult){
        int index = 0;
        while(((bitResult & 1) == 0) && index < 32){    //int占4个字节 一个字节8位 共32位
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    private static boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }

    public static void main(String[] args) {
        int[] array={1,2,2,3,3,4,5,5};
        int[] num1=new int[1];
        int[] num2=new int[1];
        FindNumsAppearOnce2(array,num1,num2);
        System.out.println(num1[0]+" "+num2[0]);
    }
}
