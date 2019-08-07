package BFSandDFS;

import java.util.*;
/**
 * leetcode 127 WordLadder
 * @author xjh 2019.03.17
 * 这道题利用bfs来做
 */
public class t127_WordLadder {
    //第一种方法 用时比较长 比较慢
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;   //边界条件
        wordList.add(beginWord);
        int n=wordList.size();
        int end=0;
        for (end=0;end<n;end++){
            if (wordList.get(end).equals(endWord)) break;
        }//end为endWord的位置
        //构建list中每个单词 相关联的单词【在题中的意思是二者只有一个字母不同】
        List<Integer>[] graphic=new List[n];
        for (int i=0;i<n;i++){
            graphic[i]=new ArrayList<>();
            for (int j=0;j<n;j++){
                if (isConnect(wordList.get(i),wordList.get(j))) graphic[i].add(j);
            }
        }
        return getShortestPath(graphic,n-1,end);
    }
    //判断量子字符串之间是否只有一个字母不同
    public boolean isConnect(String i,String j){
        int diffCount=0;
        for (int k=0;k<i.length()&&diffCount<=1;k++){
            if (i.charAt(k)!=j.charAt(k)) diffCount++;
        }
        return diffCount==1;
    }

    /**
     * BFS进行遍历
     * @param graphic
     * @param start
     * @param end
     * @return
     */
    public int getShortestPath(List<Integer>[] graphic,int start,int end){
        Queue<Integer> queue=new LinkedList<>();   //辅助队列
        boolean[] visited=new boolean[graphic.length];
        queue.add(start);
        visited[start]=true;
        int path=1;
        while (!queue.isEmpty()){
            int size=queue.size();
            path++;
            while (size-->0){
                int cur=queue.poll();
                for (int next:graphic[cur]){
                    if (next==end) return path;
                    if (visited[next]) continue;    //以访问过的数据 直接执行下一次循环
                    visited[next]=true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    //第二种方法 网上答案 同样是BFS的思想 但用起来更加灵活 有点难想到
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;   //边界条件
        Set<String> beginSet=new HashSet<>(),endSet=new HashSet<>();

        int len=1;
        Set<String> visited=new HashSet<>(); //访问标记

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty()&&!endSet.isEmpty()){
            if (beginSet.size()>endSet.size()){
                //交换
                Set<String> set=beginSet;
                beginSet=endSet;
                endSet=set;
            }

            Set<String> temp=new HashSet<>();
            for (String word:beginSet){
                char[] chs=word.toCharArray();
                for (int i=0;i<chs.length;i++){
                    for (char c='a';c<='z';c++){
                        char old=chs[i];
                        chs[i]=c;   //这里变成了每个位置 用每个字符去试一下？？
                        String target=String.valueOf(chs);

                        if (endSet.contains(target)) return len+1;
                        if (!visited.contains(target)&&wordSet.contains(target)){
                            //将只有一个字母不同的 没有访问过的 添加
                            temp.add(target);
                            visited.add(target);    //以访问
                        }
                        chs[i]=old;
                    }
                }
            }
            beginSet=temp;  //这里beginSet中的元素有原来的hit 变成了hot
            len++;
        }
        return 0;
    }

    public static void main(String[] args) {
        t127_WordLadder xjh=new t127_WordLadder();
        String[] str={"hot","dot","dog","lot","log","cog"};
        List<String> temp= Arrays.asList(str);
        List<String> wordList=new ArrayList<>();
        wordList.addAll(temp);  //需要一个list中间过度一下
        int shortestLen=xjh.ladderLength2("hit","cog",wordList);
        System.out.println(shortestLen);
    }
}
