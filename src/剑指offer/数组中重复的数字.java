package 剑指offer;

import java.util.Arrays;

/**
 * 注意，题干中的意思是 请找出数组中任意一个重复的数字
 * @author xjh 2019.04.28
 */
public class 数组中重复的数字 {
    //注意 剑指offer这个函数的返回值是boolean类型 有重复值返回true 无则返回false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length==0) return false;
        Arrays.sort(numbers);
        duplication[0]=-1;
        for (int i=0;i<length-1;i++){
            int temp=(numbers[i]==numbers[i+1])?numbers[i]:-1;
            if (temp!=-1) duplication[0]=temp;
            if(duplication[0]!=-1) break;
        }
        if (duplication[0]==-1) return false;
        else return true;
    }

    //方法2
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
        boolean[] k = new boolean[length];
        for (int i = 0; i < k.length; i++) {
            if (k[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }
}
