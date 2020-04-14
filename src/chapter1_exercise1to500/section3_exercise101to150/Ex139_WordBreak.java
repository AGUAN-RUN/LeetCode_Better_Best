package chapter1_exercise1to500.section3_exercise101to150;

import java.util.*;

/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
*/
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
