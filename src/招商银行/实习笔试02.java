package 招商银行;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 暑期实习 IT大数据方向 第二题
 * @author xjh 2019.04.09
 */
public class 实习笔试02 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Double w=in.nextDouble();
        Double[] cup=new Double[2*n];
        for (int i=0;i<cup.length;i++){
            cup[i]=in.nextDouble();
        }
        Arrays.sort(cup);   //首先对其升序排序 前一半给女生 后一半男生
        Double x1,sum;//x1为女生杯子中水 x2为男生
        if ((x1=w/(3*n))<=cup[0]){  //w用完 x1的值小于等于cuo[0]
            if (2*x1<=cup[n]){  //同时满足 则得到最大值
                String res = String .format("%.6f",w);
                System.out.println(res);
                return;
            }else {//2*x1>cup[n] 按照cup[n]最多转多少来转
                x1=cup[n]/2;
                sum=x1*3*n;
                String res = String .format("%.6f",sum);
                System.out.println(res);
                return;
            }
        }else {//(x1=w/(3*n))>cup[0]
            x1=cup[0];
            if (2*x1<=cup[n]){
                sum=x1*3*n;
                String res = String .format("%.6f",sum);
                System.out.println(res);
                return;
            }else {
                x1=cup[n]/2;
                sum=x1*3*n;
                String res = String .format("%.6f",sum);
                System.out.println(res);
                return;
            }
        }
    }

}
