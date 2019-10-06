package 快手2019.t20190916;

import java.util.Scanner;

public class 验证IP地址 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        int val=255;
        if(s.indexOf('.')>=0){
            String[] str=s.split("\\.");
            //Java中 这些字符需要前面加转义字符"\\"   ( [ { / ^ - $ ¦ } ] ) ? * + .
            for (int i=0;i<str.length;i++){
                if (str[i].charAt(0)=='0'){
                    System.out.println("Neither");
                    return;
                }
                int temp=Integer.parseInt(str[i]);
                if (temp>val||temp<0){
                    System.out.println("Neither");
                    return;
                }
            }
            System.out.println("IPv4");
            return;
        }
        String[] str=s.split(":");
        for (int i=0;i<str.length;i++){
            if (str[i]==null||str[i].length()==0||str[i].length()>4){
                System.out.println("Neither");
                return;
            }
        }
        System.out.println("IPv6");
    }
}
