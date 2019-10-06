package 猿辅导;

import java.util.ArrayList;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(),m=in.nextInt();
        String[] str=new String[m];
        ArrayList<ArrayList<String>> res=new ArrayList<>();
        for (int i=0;i<m;i++){
            str[i]=in.nextLine();
            String[] temp=str[i].split(" ");
            ArrayList<String> t=new ArrayList<>();
            for (int j=0;j<temp.length;j++) t.add(temp[j]);
            res.add(t);
        }
        String[] ss=new String[n];
       for (int i=0;i<n;i++){
            ss[i]=in.nextLine();
        }
        if (Integer.valueOf(res.get(0).get(0))>Integer.valueOf(res.get(1).get(0))){
            System.out.println(res.get(0).get(2));
            System.out.println(res.get(1).get(2));
        }else {
            System.out.println(res.get(1).get(2));
            System.out.println(res.get(0).get(2));
        }

    }
}
