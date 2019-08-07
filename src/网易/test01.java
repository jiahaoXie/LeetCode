package 网易;
import java.util.Scanner;

/**
 * 网易春招实习真题 第一题 转方向[n次向左或向右转 得到最后的解]
 * @author xjh 2019.03.31
 */
public class test01 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String s=in.nextLine();
        char d='N'; //初始方向向北
        char[] direction={'N','E','S','W'}; //初始四个方向 默认顺时针 也就是一直向右转r
        int j=0;
        for (int i=0;i<n;i++){
            if (s.charAt(i)=='R'){
                if (j==direction.length-1){
                    d=direction[0];
                    j=0;
                }
                else d=direction[++j];
            }
            else if (s.charAt(i)=='L'){
                if (j==0){
                    d=direction[direction.length-1];
                    j=direction.length-1;
                }
                else d=direction[--j];
            }
        }
        System.out.println(d);
    }
}
