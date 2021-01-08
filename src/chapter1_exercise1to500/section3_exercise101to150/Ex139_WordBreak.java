package chapter1_exercise1to500.section3_exercise101to150;

import java.util.*;

/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
*/

/*
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
* */
public class Ex139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        //List查找是否存在时间复杂度为 O(n)  Set  O(1)  要查找很多次
        Set<String> wordDictSet=new HashSet<>(wordDict);
        Map<Integer,Boolean> temp=new HashMap<>();
        int length=s.length();
        return workBreakWorker(s,wordDictSet,temp,0,length);
    }
    //动态规划  用时35ms 击败5.53%的用户
    public boolean workBreakWorker(String s,Set<String>wordDictSet,Map<Integer,Boolean>temp,int st,int length){
        //最坏情况时间复杂度达到n^n
            /* if(st==length)return true;
             for(int i=st+1;i<=length;i++){
                 if(wordDictSet.contains(s.substring(st,i))){
                     if(workBreakWorker(s,wordDictSet,i,length))return true;
                 }
             }
             return false;*/
        //优化  用一个数组存储已经计算的子问题的解，避免对子问题多次重复求解来提高效率
        if(st==length)return true;
        for(int i=st+1;i<=length;i++){
            if(wordDictSet.contains(s.substring(st,i))&&!temp.containsKey(st)){
                if(workBreakWorker(s,wordDictSet,temp,i,length))return true;
            }
        }
        temp.put(st,false);
        return false;
    }
}
