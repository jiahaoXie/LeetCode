package 网易.test20190802;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 按位与 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        int q=in.nextInt();
        in.nextLine();
        while (q-->0){
            String tmp=in.nextLine();
            String[] t=tmp.split(" ");
            int count=Integer.valueOf(t[0]);
            int x=Integer.valueOf(t[1]);
            if (count==1) list.add(x);
            else {
                if (list.contains(x)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
