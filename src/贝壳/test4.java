package 贝壳;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int[] memory = new int[n];
        long res = 0;
        for (int i = 0; i < n; i++) {
            memory[i] = scanner.nextInt();
        }
        int t = 0;
        for (int i = memory.length - 1; i > 0; i--) {
            if (memory[i] >= memory[i - 1]) {
                t = i;
                break;
            }
        }
        for (int i = 0; i < t - 1; i++) {
            if (memory[i] < memory[i + 1]) {
                continue;
            } else {
                int dif = memory[i] - memory[i + 1];
                res += dif + 1;
                memory[i + 1] += dif + 1;
            }
        }
        int sub=0;
        if(t != 0 && memory[t] == memory[t-1])
            res += 1;
        for (int j=memory.length-3;j>=0;j--){
            int k=j+2;
            if(memory[j]-memory[k]>1){
                sub=memory[j+1]-(memory[k]+1);
                memory[j+1]=memory[k]+1;
                res-=sub;
            }
        }
        System.out.println(res);
    }
}

