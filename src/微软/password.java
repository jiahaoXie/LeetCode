package 微软;

import java.util.Scanner;

/**
 * @author xjh 2019.09.22
 */
public class password {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String s=in.nextLine();
        String[] ss=s.split(",");
        int count=1;   //至少是一个密码
        for (int i=0;i<ss.length-1;i++){
            for (int j=i+1;j<ss.length;j++){
                if (ss[j]=="") continue;
                if (ss[i]==ss[j]) ss[j]=""; //将相同的密码等于空
                boolean flag=judge(ss[i],ss[j]);
                if (flag==true) ss[j]="";
                else count++;
            }
        }
        System.out.println(count);
    }
    public static boolean judge(String x,String y){
        if (x.length()!=y.length()) return false;
        for (int i=0;i<x.length();){
            if (x.charAt(i)==y.charAt(i)){
                i++;//接着往后遍历
            }else {
                //不相同判断是否可以替换
                int k=x.indexOf(y.charAt(i));
                if ((k+i)%2==0) i++;
                else return false;
            }
        }
        return true;    //false表示不能转换 true表示可以转换
    }
}
