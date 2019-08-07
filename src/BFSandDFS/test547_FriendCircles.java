package BFSandDFS;

/**
 * leetcode 547 Friend Circles
 * @author xjh 2019.01.22
 * 这道题和200高度相似  可用DFS和并查集来做
 * 利用dfs做 不同于200题 这里应该视为无向图的邻接矩阵形式
 */
public class test547_FriendCircles {
    public static int count;
    //方法1 并查集
    public static int findCircleNum(int[][] M) {
        int n=M.length;
        if (n==0) return 0;
        int[] roots=new int[n];
        count=n;
        for (int i=0;i<roots.length;i++)
            roots[i]=-1;    //初始化并查集数组
        //开始寻找朋友关系
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i!=j&&M[i][j]==1){  //不考虑对角线
                        union(roots,i,j);
                }
            }
        }
        return count;
    }

    //并查集必备的几个函数
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
            count--;    //合并一次 剪一次
        }
    }

    //方法2 无向图 dfs不再是4个方向上下左右遍历 而是考虑逐行遍历 得到直接或者间接朋友
    //这里需要设置访问数组visited 表示n个是否被访问
    //这道题和200 可作为dfs解题的典范
    public int findCircleNum2(int[][] M) {
        int n=M.length;
        if (n==0) return 0;
        count=0;
        boolean[] visited=new boolean[n];
        for (int i=0;i<n;i++){
                if (!visited[i]){
                    count++;
                    dfs(M,i,visited);
                }
        }
        return count;
    }
    public void dfs(int[][] M,int i,boolean[] visited){
        if (visited[i]) return;//递归终止条件 已经遍历的不再遍历
        visited[i]=true;
        for (int k=0;k<M.length;k++){
            if (M[i][k]==1) dfs(M,k,visited);
        }
    }

    public static void main(String[] args) {
        test547_FriendCircles xjh=new test547_FriendCircles();

        int[][] M={{1,0,0,1},
                    {0,1,1,0},
                    {0,1,1,1},
                    {1,0,1,1}};
        System.out.println(xjh.findCircleNum2(M));
    }
}
