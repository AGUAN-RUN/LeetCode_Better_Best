package chapter1_exercise1to500.section3_exercise101to150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

* */

//25ms  击败88%
public class Ex127_WordLadder_2 {
    //beginWords是开始顶点，寻找可以到达的第一级顶点，再通过联通第一级顶点寻找第二级可以到达的顶点...直到找到endWords中的顶点
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null||wordList.size()==0||wordList.get(0)=="")return 0;
        HashSet<String>words=new HashSet<>(wordList);
        if(!words.contains(endWord))return 0;
        HashSet<String>beginWords = new HashSet<>();
        beginWords.add(beginWord);
        HashSet<String>endWords=new HashSet<>();
        endWords.add(endWord);
        return ladderLengthWorker(beginWords,endWords,words,2);
    }
    public int ladderLengthWorker(Set<String> beginWords,Set<String> endWords, Set<String>words, int deep){
        //开始-->结束等价于结束-->开始    用单词数量少的来作为begin并搜索
        if(beginWords.size()>endWords.size()){
           return ladderLengthWorker(endWords,beginWords,words,deep);
        }
        words.remove(beginWords);
        HashSet<String>next=new HashSet<>();
       for(String s:beginWords){
           char[]strs=s.toCharArray();
           for(int i=0;i<strs.length;i++){
               char cr=strs[i];
               for(char j='a';j<='z';j++){
                   if(cr==j)continue;
                   strs[i]=j;
                   String temp=new String(strs);
                   if(endWords.contains(temp))return deep;
                   if(words.contains(temp))next.add(temp);
               }
               strs[i]=cr;
           }
       }
        //断流了返回0
        if(next.size()==0)return 0;
        return ladderLengthWorker(next,endWords,words,deep+1);
    }

    public static void main(String[] args) {
        //["hot","dot","dog","lot","log","cog"]
        //"hit"
        //"cog"
        List<String>strs=new ArrayList<>();
        strs.add("hot");
        strs.add("dot");
        strs.add("dog");
        strs.add("lot");
        strs.add("log");
        strs.add("cog");
        String s1="hit";
        String s2="cog";
        Ex127_WordLadder_2 test=new Ex127_WordLadder_2();
        test.ladderLength(s1,s2,strs);

    }
}
