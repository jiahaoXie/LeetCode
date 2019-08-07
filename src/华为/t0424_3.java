package 华为;

import java.util.Scanner;
/**
 * 还原密码
 * @author xjh 2019.04.24
 * 分析每个单词组成（暴力穷举法）
 */

public class t0424_3 {
    public static boolean ishas(int arr[],char c){
        return arr[c-'a']>0;
    }
    public static boolean ishas(int arr[],char c,int num){
        return arr[c-'a']-num>0;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String temp=in.nextLine();
        String s=temp.toLowerCase();    //首先转换为小写
        int[] arr=new int[26];
        int count=0;
        int[] num=new int[10];  //数字个数
        for (char c:s.toCharArray()){
            arr[c-'a']++; //统计每个字符的个数
            count++;
        }

        while (count!=0){
            //7seven
            while (ishas(arr,'s')&&ishas(arr,'e',2)&&ishas(arr,'v')&&ishas(arr,'n')){
                arr['s'-'a']--;
                arr['e'-'a']--;
                arr['v'-'a']--;
                arr['e'-'a']--;
                arr['n'-'a']--;
                count-=5;
                num[7]++;
            }
            //8eight
            while (ishas(arr,'e')&&ishas(arr,'i')&&ishas(arr,'g')&&ishas(arr,'h')&&ishas(arr,'t')){
                arr['e'-'a']--;
                arr['i'-'a']--;
                arr['g'-'a']--;
                arr['h'-'a']--;
                arr['t'-'a']--;
                count-=5;
                num[8]++;
            }
            //3
            while (ishas(arr,'t')&&ishas(arr,'h')&&ishas(arr,'r')&&ishas(arr,'e',2)){
                arr['t'-'a']--;
                arr['h'-'a']--;
                arr['r'-'a']--;
                arr['e'-'a']--;
                arr['e'-'a']--;
                count-=5;
                num[3]++;
            }


            //4
            while (ishas(arr,'f')&&ishas(arr,'o')&&ishas(arr,'u')&&ishas(arr,'r')){
                arr['f'-'a']--;
                arr['o'-'a']--;
                arr['u'-'a']--;
                arr['r'-'a']--;
                count-=4;
                num[4]++;
            }
            //5
            while (ishas(arr,'f')&&ishas(arr,'i')&&ishas(arr,'v')&&ishas(arr,'e')){
                arr['f'-'a']--;
                arr['i'-'a']--;
                arr['v'-'a']--;
                arr['e'-'a']--;
                count-=4;
                num[5]++;
            }
            //9
            while (ishas(arr,'n',2)&&ishas(arr,'i')&&ishas(arr,'e')){
                arr['n'-'a']--;
                arr['i'-'a']--;
                arr['n'-'a']--;
                arr['e'-'a']--;
                count-=4;
                num[9]++;
            }
            //1one
            while (ishas(arr,'o')&&ishas(arr,'n')&&ishas(arr,'e')){
                arr['o'-'a']--;
                arr['n'-'a']--;
                arr['e'-'a']--;
                count-=3;
                num[1]++;
            }
            //2
            while (ishas(arr,'t')&&ishas(arr,'w')&&ishas(arr,'o')){
                arr['t'-'a']--;
                arr['w'-'a']--;
                arr['o'-'a']--;
                count-=3;
                num[2]++;
            }
            //6
            while (ishas(arr,'s')&&ishas(arr,'i')&&ishas(arr,'x')){
                arr['s'-'a']--;
                arr['i'-'a']--;
                arr['x'-'a']--;
                count-=3;
                num[6]++;
            }
            //0zero
            while (ishas(arr,'z')&&ishas(arr,'e')&&ishas(arr,'r')&&ishas(arr,'o')){
                arr['z'-'a']--;
                arr['e'-'a']--;
                arr['r'-'a']--;
                arr['o'-'a']--;
                count-=4;
                num[0]++;
            }
        }

        for (int i = 0; i < 10; i++) {
            while (num[i]>0){
                System.out.print(i);
                num[i]--;
            }
        }
    }
}
