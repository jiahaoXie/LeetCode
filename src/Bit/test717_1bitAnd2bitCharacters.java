package Bit;

/**
 * leetcode 7171:1-bit and 2-bit Characters
 * @author xjh 2019.01.04
 */
public class test717_1bitAnd2bitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        //输入是一个只包含0 1的数组（它只能用10 11 0三种表示）
        //1.判断数组中的倒数第二位是否为0 为o一定是true
//        if (bits[bits.length-2]==0) return true;  //这句要注释掉 因为会存在数组一共只有两个元素的案例（运行汇报错误）
        //这里用一个巧妙的方法 因为当前下标是1的话 需要连着2个字符表示 是0的话，只需一个
        int i=0;
        while (i<bits.length-1){
            i+=bits[i]+1;
        }
        return i==bits.length-1;
    }

    public static void main(String[] args) {

    }
}
