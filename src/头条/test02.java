package 头条;

import java.util.Scanner;

/**
 * @author xjh 2019.03.16
 */
public class test02 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();  //输入空行
        String[] str=new String[n];
        for (int i=0;i<n;i++)
            str[i]=in.nextLine();
        //每一行校验
        for (int i=0;i<n;i++){
            //1.3个或3个以上 字母连在一起 进行修改
            int j=0;
            while (j<str[i].length()-2){
                if (str[i].charAt(j)==str[i].charAt(j+1)&&str[i].charAt(j+1)==str[i].charAt(j+2)){
                    str[i]=str[i].substring(0,j+2)+str[i].substring(j+3);
                }else j++;
            }
            //2. 两对一样的字母 修改
            int k=0;
            while(k<str[i].length()-3){
                if (str[i].charAt(k)==str[i].charAt(k+1)&&str[i].charAt(k+2)==str[i].charAt(k+3)){
                    str[i]=str[i].substring(0,k+3)+str[i].substring(k+4);
                }else k++;
            }
        }
        for (String s:str)
            System.out.println(s);
    }
}
