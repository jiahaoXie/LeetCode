package BFSandDFS;

import java.util.Scanner;

/**
 * leetcode 200 Number of Islands
 * @author xjh 2019.01.21
 */
public class test200_NumberofIslands {
    public static int numIslands(char[][] grid) {
        int n=grid.length;
        if (n==0) return 0;
        int m=grid[0].length;
        int count=0;
        //方法1：遍历所有为1的节点 利用DFS将1上下左右周围的1都消除为0
//        for (int i=0;i<n;i++){
//            for (int j=0;j<m;j++){
//                if (grid[i][j]=='1'){
//                    DFS(grid,i,j);  //递归
//                    count++;
//                }
//            }
//        }
//        return count;

        //方法二 利用并查集
        int[] roots=new int[n*m];
        for (int i=0;i<n*m;i++)
            roots[i]=-1;    //因为这里不知道二维数组中的元素是0是1 所以先初始化为-1
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]=='1'){
                    //上下左右为1的元素进行合并
                    if (i-1>=0&&grid[i-1][j]=='1') union(roots,i*m+j,(i-1)*m+j);
                    if (i+1<n&&grid[i+1][j]=='1') union(roots,i*m+j,(i+1)*m+j);
                    if (j-1>=0&&grid[i][j-1]=='1') union(roots,i*m+j,i*m+j-1);
                    if (j+1<m&&grid[i][j+1]=='1') union(roots,i*m+j,i*m+j+1);
                }
            }
        }
        return count(roots,grid);
    }

    public static void DFS(char[][] grid,int i,int j){
        if (i<0||j<0||i>=grid.length||j>=grid[0].length) return;   //到达边界 递归终止条件
        if (grid[i][j]=='1'){
            grid[i][j]='0';
            DFS(grid,i-1,j);
            DFS(grid,i+1,j);
            DFS(grid,i,j-1);
            DFS(grid,i,j+1);
        }
  }
  //以下是并查集 的几个必备函数
    public static int find(int[] roots,int i){
        while (roots[i]>=0) //循环找到i的根节点 因为初始化中我们吧根节点的值都赋值为-1
            i=roots[i];
        return i;//这里返回的值下标值
    }
    public static void union(int[] roots,int i,int j){
        int parentI=find(roots,i),parentJ=find(roots,j);
        if (parentI!=parentJ){
            if (-roots[parentI]>=-roots[parentJ]){
                roots[parentI]+=roots[parentJ];
                roots[parentJ]=parentI;
            }
            else{
                roots[parentJ]+=roots[parentI];
                roots[parentI]=parentJ;
            }
        }
    }

    private static int count(int[] roots,char[][] grid){
        int n=grid.length,m=grid[0].length;
        int total=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]=='1'&&roots[i*m+j]<0){
                    total+=1;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] s=new String[4];
        for (int i=0;i<s.length;i++){
            s[i]=in.nextLine();
        }
        char[][] grid=new char[4][s.length];
        for (int i=0;i<4;i++)
            grid[i]=s[i].toCharArray();
        System.out.println(numIslands(grid));
//        for (String t:s)
//            System.out.println(t);
    }

}
