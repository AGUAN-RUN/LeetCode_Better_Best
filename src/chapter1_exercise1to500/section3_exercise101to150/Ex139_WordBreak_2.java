package chapter1_exercise1to500.section3_exercise101to150;

import java.lang.reflect.Array;
import java.util.*;

/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
*/
public class Ex139_WordBreak_2 {
    //优化用数组之后  用时8ms击败  68.83的用户
    //优化，拿到wordDict的字符串的最长字符串与最短字符串  测试用时2ms 击败96.76%的用户
    public boolean wordBreak(String s, List<String> wordDict) {
        //List查找是否存在时间复杂度为 O(n)  Set  O(1)  要查找很多次
        Set<String> wordDictSet=new HashSet<>(wordDict);
        int length=s.length();
        //用数组不用map
        int minLength=Integer.MAX_VALUE;
        int maxLength=1;
        //最大值和最小值同时要刷新
        for(int i=0;i<wordDict.size();i++){
            int l=wordDict.get(i).length();
            if(l<minLength){
                minLength=l;
            }
            if(l>maxLength){
                maxLength=l;
            }
        }
        boolean[]temp=new boolean[length+1];
        Arrays.fill(temp,true);
        return workBreakWorker(s,wordDictSet,temp,0,length,minLength,maxLength);
    }
    //动态规划  用时35ms 击败5.53%的用户
    public boolean workBreakWorker(String s,Set<String>wordDictSet,boolean[]temp,int st,int length,int minLength,int maxLength){
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
        //字串不得小于minLength，不得大于maxLength
        for(int i=st+minLength;i<=length;i++){
            if(i-st>maxLength)break;
            if(wordDictSet.contains(s.substring(st,i))&&temp[i]){
                if(workBreakWorker(s,wordDictSet,temp,i,length,minLength,maxLength))return true;
            }
        }
        temp[st]=false;
        return false;
    }

    public static void main(String[] args) {
        String s="applepenapple";
        List<String>strs=new ArrayList<>();
        strs.add("apple");
        strs.add("pen");
    }
}
