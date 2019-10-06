package B站;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String[] ss=s.split(" ");
        String[] kv=ss[2].split(ss[0]);
        System.out.println(kv.length);
        for (int i=0;i<kv.length;i++){
            String[] res=kv[i].split(ss[1]);
            System.out.println(res[0]+" "+res[1]);
        }
    }
}
