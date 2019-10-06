package 京东;

import java.util.Scanner;

public class 大小写字母 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String s=in.nextLine();
        int count=0,up=0,low=0; //up统计当前位置之前连续出现大写的次数
        for (int i=0;i<s.length();i++){
            if (i==0){//首字母
                if (s.charAt(i)>='A'&&s.charAt(i)<='Z') {
                    count+=2;
                    up++;
                }
                else{
                    count+=1;
                    low++;
                }
            }
            else {
                //1.i i-1字母相同 则次数加1
                if (pandaun(s.charAt(i-1),s.charAt(i))){
                    count+=1;
                    if (s.charAt(i)>='A'&&s.charAt(i)<='Z') up++;
                    else low++;
                }//前后两个字母不同 看前面一个字母是否大写
                else {
                    if (s.charAt(i-1)>='A'&&s.charAt(i-1)<='Z'){//i-1大写 i小写
                        if (up==1) {
                            count+=1;
                        }else count+=2;
                        low=1;
                    }else {//i-1小写 i大写
                        if (low==1&&i==3) count+=1;
                        else count+=2;
                        up=1;
                    }
                }
            }
        }
        System.out.println(count);
    }
    public static boolean pandaun(char i, char j){
        if (i>='A'&&i<='Z'&&j>='A'&&j<='Z') return true;
        else if (i>='a'&&i<='z'&&j>='a'&&j<='z') return true;
        return false;
    }
}
