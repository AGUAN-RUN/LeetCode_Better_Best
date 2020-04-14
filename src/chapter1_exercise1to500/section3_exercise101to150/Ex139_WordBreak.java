package chapter1_exercise1to500.section3_exercise101to150;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
*/
public class Ex139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        //List查找是否存在时间复杂度为 O(n)  Set  O(1)  要查找很多次
        Set<String> wordDictSet=new HashSet<>(wordDict);
        int length=s.length()
        workBreakWorker(s,wordDictSet,0,length);
    }
    public boolean workBreakWorker(String s,Set<String>wordDictSet,int st,int length){
             if(st==length)return true;
             for(int i=st+1;i<=length;i++){
                 if(wordDictSet.contains(s.substring(st,i))){
                     if(workBreakWorker(s,wordDictSet,i,length))return true;
                 }

             }
    }
}
