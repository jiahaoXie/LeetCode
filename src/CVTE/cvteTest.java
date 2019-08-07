package CVTE;

/**
 * 新郎新娘问题 (cvte后台笔试第二道编程题)
 * @author xjh  2018.12.07
 * 题目描述：
    * * 有30对夫妻，第一对中新郎编号为0，新娘编号为1；第二对中新郎编号为2，新娘编号为3；.....
     * 所有人坐成一排，要求每队夫妻坐在一起，但是不要求谁做谁的左边
     * 一开始，所有都是乱序的，请问最少经过几次调换座位，能使所有夫妻坐在一起。
     * 例如：
     * 乱序为：[0,3,1,2]
     * 调换思路：   3和1互换
     * 调换次数 ：  1
     * 调换详情：   1<-------------->2
     * 
     * 
     * e.g
     * 乱序为：[0,4,1,2,5,3]
     * 调换思路：   4先和1调换，然后2和5调换
     * 调换次数 ：  2
     * 调换详情：   
     * 4<-------------->1
     * 2<-------------->5
        解题思路：(网上百度得到的 有问题 ？？？ 不对 这应该是个DP问题)
     * 所有人封装进一个数组，从数组第一位x开始遍历
     * A.当第一位x为新郎时（偶数）
     *   |---如果其下一位y（也就是第二位）的值存在arr[x]+1==arr[y]
     *      ① |---那么下次从第三位开始遍历（也就是第一位的下一位的下一位）
     *   |---如果其下一位y（也就是第二位）的值不存在arr[x]+1==arr[y]
     *     ②  |---遍历剩下的值，直到出现arr[x]+1==arr[m],那么下次从第三位开始遍历（也就是第一位的下一位的下一位）
     *           |--- y 和  m 位置交换,
     *重复①②动作
     * B.当第一位x为新娘时（奇数）
     *   |---如果其下一位y（也就是第二位）的值存在arr[x]-1==arr[y]
     *       ①  |---那么下次从第三位开始遍历（也就是第一位的下一位的下一位）
     *   |---如果其下一位y（也就是第二位）的值不存在arr[x]-1==arr[y]
     *     ②   |---遍历剩下的值，直到出现arr[x]+1==arr[m],那么下次从第三位开始遍历（也就是第一位的下一位的下一位）
     *           |--- y 和  m 位置交换,
     * 重复①②动作
     * 
     * 设置一个值，每次交换一次，该值加1
 */
public class cvteTest {
    public static void main(String[] args) {
//        int[] arr={0,4,1,2,5,3};
        int[] arr={0,4,2,5,1,3,7,8,10,9};
        int count=exchange(arr,0,0);
        System.out.println(count);
    }
    public static int exchange(int[] arr,int a,int num){
        if (a>=arr.length) return num;
        if(arr[a]%2==0){
            //第一位是新郎
            int y=a+1;
            if (arr[a]+1==arr[y]){
                //新郎隔壁为其对应的新娘，符合
                a+=2;
                num=exchange(arr,a,num);    //递归往后重复操作
            }else {
                while (arr[a]+1!=arr[y]) y++;   //不符合 则继续往后遍历 直到找到为止
                swap(a+1,y,arr);    //交换元素
                a+=2;
                num++;
                num=exchange(arr,a,num);
            }
        }else{
            //第一位是新娘
            int y=a+1;
            if(arr[a]-1==arr[y]){//新娘的隔壁为其新郎，符合
                a=a+2;               //跳过新郎，继续循环
                num=exchange(arr,a,num);//继续
            }else{
                while(arr[a]-1!=arr[y]){  //如果新娘的隔壁不是其新郎，不符合，遍历剩下的人，直到找到为止
                    y++;
                }
                swap(a+1,y,arr);            //找到新娘对应的新郎，交换位置
                a=a+2;						//跳过新娘，继续循环
                num++;            //交换次数加1
                num =exchange(arr,a,num);
            }
        }
        return num;
    }
    public static void swap(int x,int y,int[] arr){
        System.out.println(arr[x]+"<------------------>"+arr[y]);
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}
