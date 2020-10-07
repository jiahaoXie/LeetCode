package 阿里巴巴;

import java.util.ArrayList;
import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String ss=in.nextLine();
        String[] res=ss.split(",");
        ArrayList<ArrayList<String>> list=new ArrayList<>();
        while (in.hasNextLine()){
            String temp=in.nextLine();
            ArrayList<String> st=new ArrayList<>();
            if (temp.equals("a")) break;
            String[] str=temp.split(",");
            if (str[1].equals("NULL")){
               st.add(str[0]);
               if (!list.contains(st)) list.add(st);
            }else{
                boolean flag=false;
               //有两个元素
//                st.add(str[1]);
                for (ArrayList<String> tt:list){
                    if (tt.get(0).equals(str[1])){
                        tt.add(str[0]);
                        flag=true;
                    }
                }
                if (flag==true){
                    //没有
                    st.add(str[1]); st.add(str[0]);
                    list.add(st);
                }
            }
        }//接手输入结束
        for (ArrayList<String> ttt:list)
            System.out.println(ttt);

    }
}
