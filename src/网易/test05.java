package 网易;

import java.util.Scanner;
public class test05 {
    private static char[][] array = null;
    private static int[][] status = null;
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n   = sc.nextInt();
        int m   = sc.nextInt();
        int res = 0;
        array   = new char[n][m];
        status  = new int[n][m];
        char commen = '.';
        String input = null;
        for(int i = 0; i < n; i++){
            input = sc.next();
            for(int j = 0; j < m; j++){
                array[i][j] = input.charAt(j);
            }
        }
        int  x = sc.nextInt();
        int  y = sc.nextInt();
        char now  = sc.next().charAt(0);
        int total = sc.nextInt();
        String option = sc.next();

        int flag = 0;

        switch (now) {
            case 'U': flag = 1;break;
            case 'R': flag = 2;break;
            case 'D': flag = 3;break;
            case 'L': flag = 4;break;
            default:
                break;
        }

        status[x][y] = flag;

        if(array[x][y] != '.' && (total +48) >= array[x][y]){
            int add = array[x][y] - '0';
            res += add;
            array[x][y] = '.';
            total -= add;
        }



        for(int i = 0; i < option.length(); i++){
            char current = option.charAt(i);
            if(current == 'R'){

                if(status[x][y] < 4){
                    status[x][y]++;
                }else {
                    status[x][y] = 1;
                }
            }else if(current == 'L'){

                if(status[x][y] > 1){
                    status[x][y]--;
                }else {
                    status[x][y] = 4;
                }
            }else {

                if(status[x][y] == 1){
                    if(x == 0){
                        continue;
                    }
                    x--;
                    status[x][y] = 1;
                }else if(status[x][y] == 2){
                    if(y == m-1){
                        continue;
                    }
                    y++;
                    status[x][y] = 2;
                }else if(status[x][y] == 3){
                    if(x == n-1){
                        continue;
                    }
                    x++;
                    status[x][y] = 3;
                }else {
                    if(y == 0){
                        continue;
                    }
                    y--;
                    status[x][y] = 4;
                }


                if(array[x][y] != '.' && (total +48) >= array[x][y]){

                    int add = array[x][y] - '0';
                    res += add;
                    array[x][y] = '.';
                    total -= add;
                }

            }

        }

        System.out.println(res);
    }
}
