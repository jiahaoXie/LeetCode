package 度小满;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNextLine()){
            int x=in.nextInt(),y=in.nextInt();
            if (x>=2*y) System.out.println("WIN");
            else System.out.println("LOSE");
        }
    }
}
