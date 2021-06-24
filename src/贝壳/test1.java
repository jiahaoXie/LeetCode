package 贝壳;

import java.util.Scanner;

public class test1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] memory = new long[n];
        int i = 0;
        while (i < memory.length) {
            memory[i] = in.nextLong();
            i++;
        }
        long MAX = Long.MAX_VALUE;
        long x = memory[0], y = memory[1];

        for (i = 0; i < memory.length - 1; i++) {
            long temp = Math.abs(memory[i] - memory[i + 1]);
            if (temp < MAX) {
                x = memory[i];
                y = memory[i + 1];
                MAX = temp;
            }
        }
        System.out.println(x + " " + y);
    }
}
