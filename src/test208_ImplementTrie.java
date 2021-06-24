/**
 * leetcode 208 Implement Trie (Prefix Tree)
 *
 * @author xjh 2018.12.25
 */
class TrieNode {
    public char value;
    public boolean isWord;  //这个boolean表示单词结束
    public TrieNode[] children = new TrieNode[26];    //这里测试样例只需要输入a-z

    public TrieNode() {
    }

    TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.value = c;
    }
}

class Trie {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
        root.value = ' '; //Trie树的根节点不包含有效字符

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode t = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);  //word的第i个字符
            if (t.children[c - 'a'] == null)    //如果孩子节点中没有该字符 则需要插入进去
                t.children[c - 'a'] = new TrieNode(c);
            t = t.children[c - 'a'];    //树向下迭代
        }
        t.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode t = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);  //word的第i个字符
            if (t.children[c - 'a'] == null)    //如果孩子节点中没有该字符 返回false;
                return false;
            t = t.children[c - 'a'];    //树向下迭代
        }
        return t.isWord;    //search函数和startWith函数最大的区别在于后买你返回的是t.isWord
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);  //word的第i个字符
            if (tmp.children[c - 'a'] == null)    //如果孩子节点中没有该字符 返回false;
                return false;
            tmp = tmp.children[c - 'a'];    //树向下迭代
        }
        return true;
    }
}

public class test208_ImplementTrie {
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("word");
//        obj.insert("he");
        obj.insert("hello");
        System.out.println("search word:" + obj.search("word"));
        System.out.println("search he:" + obj.search("he"));
        System.out.println("startwith he:" + obj.startsWith("he"));
    }
}
