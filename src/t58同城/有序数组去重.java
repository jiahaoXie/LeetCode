package t58同城;
import java.util.Scanner;

public class 有序数组去重 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String content = scan.nextLine();
        scan.close();
        int num=0;
        if(content.length()>0) {
            char pre= content.charAt(0);
            num++;
            for(int i=0;i<content.length();i+=2) {
                char cur = content.charAt(i);
                if(cur!=pre) {
                    num++;
                    pre = cur;
                }
            }
        }
        System.out.println(num);
    }
}
