package chapter1_exercise1to500.section5_exercese201to250;

import commons.TrieNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
* */
/*
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。


* */
//Trie是前缀树的每一个树节点，该数据结构类在common包中已经实现

//用时44ms  击败80%的用户
public class Ex208_ImplementTrie_PrefixTree {
    TrieNode root;
    /** Initialize your data structure here. */
    public Ex208_ImplementTrie_PrefixTree() {
        root=new TrieNode();
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word==null||word.length()==0)return;
        char [] chars=word.toCharArray();
        TrieNode trieNode=root;
        for(int i=0;i<chars.length;i++){
            if (trieNode.contains(chars[i])) {
                trieNode = trieNode.get(chars[i]);
            } else {
                trieNode.put(chars[i], new TrieNode());
                trieNode = trieNode.get(chars[i]);
            }
            if(i==chars.length-1){
                trieNode.setIsEnd(true);
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word==null||word.length()==0)return false;
        char[]chars=word.toCharArray();
        TrieNode trieNode=root;
        for(int i=0;i<chars.length;i++){
            if(trieNode.contains(chars[i])){
                trieNode=trieNode.get(chars[i]);
            }else {
                return false;
            }
        }
        return trieNode.getIsEnd()==true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix==null||prefix.length()==0)return false;
        char[]chars=prefix.toCharArray();
        TrieNode trieNode=root;
        for(int i=0;i<chars.length;i++){
            if(trieNode.contains(chars[i])){
                trieNode=trieNode.get(chars[i]);
            }else {
                return false;
            }
        }
        return true;
    }

}
