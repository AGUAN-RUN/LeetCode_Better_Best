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
