package chapter1_exercise1to500.section5_exercese201to250;

import java.util.*;

/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
* */
/*
请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。

实现词典类 WordDictionary ：

WordDictionary() 初始化词典对象
void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 

示例：

输入：
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
输出：
[null,null,null,null,false,true,true,true]

解释：
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

提示：

1 <= word.length <= 500
addWord 中的 word 由小写英文字母组成
search 中的 word 由 '.' 或小写英文字母组成
最调用多 50000 次 addWord 和 search


* */
//执行用时53ms 击败78.74的java提交   内存消耗48.8M  击败100%的java用户
public class Ex211_AddAndSearchWord_DataStructureDesign {
    Map<Integer, HashSet<String>> map;
    /** Initialize your data structure here. */
    public Ex211_AddAndSearchWord_DataStructureDesign() {
        map=new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word==null||word.length()==0)return;
        HashSet<String> list=map.get(word.length());
        if(list!=null){
            if(!list.contains(word))list.add(word);
        }else {
            list=new HashSet<>();
            list.add(word);
            map.put(word.length(),list);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        HashSet<String>list=map.get(word.length());
        if(list==null){
            return false;
        }else{
            char[]chars=word.toCharArray();
            for(String s:list){
                for(int i=0;i<chars.length;i++){
                    if(chars[i]=='.'||chars[i]==s.charAt(i)){
                        if(i==chars.length-1)return true;
                        continue;
                    }
                    break;
                }
            }
            return false;
        }
    }
}
