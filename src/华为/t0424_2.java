package 华为;

import java.util.*;

/**
 * 华为第二题 最短路径 Dijkstra
 * @author xjh 2019.04.24
 */
class W{//带权邻接表
    int b;
    int w;
    W(int b,int w){
        this.b=b;
        this.w=w;
    }
}
class Node implements Comparable<Node>{
    int id;
    int d;
    Node(int a,int b){
        id=a;d=b;
    }
    @Override
    public int compareTo(Node o) {
        return this.d-o.d;
    }
}
public class t0424_2 {
    ArrayList<Integer> res=new ArrayList<>();
    static int m,n;
    static List<W>[] list;
    static int min=Integer.MAX_VALUE,tempMin;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        m=in.nextInt(); //m个节点
        n=in.nextInt(); //n条边
        list=new ArrayList[m+1];
        for (int i=0;i<list.length;i++)
            list[i]=new ArrayList<W>();
        int[] temp=new int[4];
        for (int i=1;i<=n;i++){
            temp[0]=in.nextInt();   //这个没用
            temp[1]=in.nextInt();
            temp[2]=in.nextInt();
            temp[3]=in.nextInt();
            list[temp[1]].add(new W(temp[2],temp[3]));
            list[temp[2]].add(new W(temp[1],temp[3]));
        }
        int start=in.nextInt(),end=in.nextInt();
        dfs(start,end);
        if (min==Integer.MAX_VALUE) System.out.println("NA");
        else System.out.println(min);
//        Dijkstra(start,end);
    }

    //dfs
    static boolean found=false;
    public static void dfs(int s,int t){
        boolean found=false;
        boolean[] visited=new boolean[m+1];
        int[] prev=new int[m+1];
//        for (int i=0;i<m;i++)
//            prev[i]=-1;
        tempMin=0;
        recurDFS(s,t,visited,prev);
//        if (prev.length>1) tempMin=tempMin-prev.length+2;
        int count=0;
        for (int i:prev){
            if (prev[i]!=-1){
                count++;
            }
        }
        if (count>2) tempMin=tempMin-count+2;
        min=Math.min(min,tempMin);
    }
    public static void recurDFS(int w,int t,boolean[] visited,int[] prev){
        if(found==true) return;//找到目标顶点后，递归终止
        visited[w]=true;
        if(w==t){
            found=true;
            return;
        }
        for (int i=0;i<list[w].size();i++){
            int q=list[w].get(i).b;
            if(!visited[q]){
                prev[q]=list[w].get(i).b;
                tempMin+=list[w].get(i).w;
                recurDFS(q,t,visited,prev);
            }
        }
    }

    //Dijkstra
    public static void Dijkstra(int s,int e){
        int v[]=new int[m+1];
        int d[]=new int[m+1];
        Queue<Node> q=new PriorityQueue<>();
        q.offer(new Node(s,0));
        while (!q.isEmpty()){
            Node x=q.poll();
            int id=x.id;
            if (v[id]==s) continue;
            if (v[id]==e){
                break;
            }
            v[id]=s;
            for(int j=0;j<list[id].size();j++){
                int bb=list[id].get(j).b;
                if (v[bb]==0){
                    int ww=list[id].get(j).w;
                    int k=Math.max(x.d,ww);
                    if (d[bb]==0||k<d[bb]){
                        d[bb]=k;
                        q.offer(new Node(bb,k));
                    }
                }
            }
        }
        System.out.println(d[e]);
    }
}
