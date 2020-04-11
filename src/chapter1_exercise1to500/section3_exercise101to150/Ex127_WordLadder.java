package chapter1_exercise1to500.section3_exercise101to150;

import java.util.ArrayList;
import java.util.List;

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

//404ms  击败44%
public class Ex127_WordLadder {
    //beginWord是开始顶点，寻找可以到达的第一级顶点，再通过联通第一级顶点寻找第二级可以到达的顶点...直到找到endWord
    // 如果所有顶点都找完了都没有找到 返回0
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null||wordList.size()==0||wordList.get(0)=="")return 0;
        List<String>beginWords = new ArrayList<>();
        for(int i=0;i<wordList.size();i++) {
            if (ifOneWordDiff(beginWord, wordList.get(i))) {
                if (wordList.get(i).equals(endWord)) return 2;
                beginWords.add(wordList.remove(i));
                i--;
            }
        }
        if(beginWords.size()==0)return 0;
        return ladderLengthWorker(beginWords,endWord,wordList,2);
    }
    //时间复杂度为beginWords.length*wordList.length*f(单词长度)
    public int ladderLengthWorker(List<String>beginWords,String endWord,List<String>wordList,int deep){
        List<String>nextWords=new ArrayList<>();
        for(int i=0;i<beginWords.size();i++){
            if(wordList.size()==0)break;
            for(int j=0;j<wordList.size();j++){
                if(ifOneWordDiff(beginWords.get(i),wordList.get(j))){
                    if(wordList.get(j).equals(endWord))return deep+1;
                    nextWords.add(wordList.remove(j));
                    j--;
                };
            }
        }
        if(nextWords.size()==0)return 0;
        return ladderLengthWorker(nextWords,endWord,wordList,deep+1);
    }

    public boolean ifOneWordDiff(String s1,String s2){
        int length=s1.length();
        int st=0;
        for(int i=0;i<length;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                st++;
                if(st>1)return false;
            }
        }
        if(st==1)return true;
        return false;
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
        Ex127_WordLadder test=new Ex127_WordLadder();
        test.ladderLength(s1,s2,strs);

    }
}
