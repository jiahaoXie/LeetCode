package 头条.Test_20190811;

import java.util.Scanner;

/**
 * 加密与解密
 */
public class test2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int mov = scanner.nextInt();
        String patter = scanner.next();
        String res = reBegin(length,mov,patter);
        System.out.println(res);
    }

    private static String reBegin(int length, int mov, String patter) {
        if(mov >= length){
            char[] cur = mainWay(length,length,patter);
            return cur.toString();
        }
        char[] cur = mainWay(length, mov, patter);
        char[] charArray = patter.toCharArray();
        for(int i = mov; i <length; i++){
            int count = 0;
            if(charArray[i] == '1'){
                count++;
            }
            for(int j = 1; j < mov; j++){
                if(cur[i-j] == '1'){
                    count++;
                }
            }
            cur[i] = (char) (count%2+'0');
        }

        return String.valueOf(cur);
    }

    private static char[] mainWay(int length, int length2, String patter) {
        char[] charArray = patter.toCharArray();
        char[] cur = new char[length];
        cur[0] = charArray[0];
        for(int i = 1; i < length2; i++){
            int count = 0;
            if(charArray[i] == '1'){
                count++;
            }
            for(int j = i-1; j>=0; j--){
                if(cur[j] == '1'){
                    count++;
                }
            }
            cur[i] = (char) (count%2+'0');
        }
        return cur;
    }
}
