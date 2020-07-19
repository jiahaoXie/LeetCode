import java.util.HashMap;

/**
 * leetcode 146 LRU Cache
 *
 * @author xjh 2019.01.22
 * 实现LRU缓存 关键在于使用双向链表存储每个节点信息 使得可以快速移除节点信息
 * 使用HashMap存储key/value对
 * 这道题难度很高,思想不难 难的是在于实现 有点难想到把节点信息作为value保存在hashmap中
 */
public class test146_LRUCache {
    class Node { //表示双链表的节点信息
        int key;
        int value;
        Node pre;   //前继指针
        Node next;  //后继指针
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    class LRU_Cache{
        HashMap<Integer,Node> map;
        int capicity,count;
        Node head,tail; //双向链表中的表头 表尾指针
        public LRU_Cache(int capicity){
            this.capicity=capicity;
            map=new HashMap<>();
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            head.pre=null;
            tail.pre=head;
            tail.next=null;
            count=0;
        }
        //实质上 删除也就是删除表尾的节点
        public void deleteNode(Node node){
            node.pre.next=node.next;
            node.next.pre=node.pre;
        }
        //LRU中增加节点到表头
        public void addNode(Node node){
            node.next=head.next;
            node.next.pre=node;
            head.next=node;
            node.pre=head;
        }

        public int get(int key){
            if (map.get(key)!=null){
                Node node=map.get(key);
                int result=node.value;
                deleteNode(node);
                addNode(node);
                return result;
            }
            return -1;
        }
        public void put(int key,int value){
            if (map.get(key)!=null){
                //原来链表里有该值 将其放到表头
                Node node=map.get(key);
                deleteNode(node);
                addNode(node);
            }else {
                //原来没有 则需要新插入一个新的节点细腻些到表头
                // 这里还需判断一下是否超过链表的范围值
                Node node=new Node(key,value);
                map.put(key,node);  //将节点信息以value形式保存
                if (count < capicity) {
                    count++;
                    addNode(node);
                }else {
                    map.remove(tail.pre.key);
                    deleteNode(tail.pre);
                    addNode(node);
                }
            }
        }

    }

}
