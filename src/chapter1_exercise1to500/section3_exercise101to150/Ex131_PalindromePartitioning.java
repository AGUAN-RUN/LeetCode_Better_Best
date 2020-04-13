package chapter1_exercise1to500.section3_exercise101to150;

import java.util.ArrayList;
import java.util.List;

/*
* Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.
* */
//测试用例执行时间 3ms  击败90%用户
public class Ex131_PalindromePartitioning {
    //递归不解释
    public List<List<String>> partition(String s) {
        List<List<String>>result =new ArrayList<>();
        if(s==null||s.length()==0)return result;
        List<String>temp=new ArrayList<>();
        partitionWorker(result,temp,s,0);
        return result;
    }
    public void partitionWorker(List<List<String>>result,List<String>temp,String s,int start){
        if(start>=s.length()){
            result.add(new ArrayList(temp));
            return;
        }
        for(int i=start;i<s.length();i++){
           if(isAPalindrome(s,start,i)){
               temp.add(s.substring(start,i+1));
               partitionWorker(result,temp,s,i+1);
               temp.remove(temp.size()-1);
           }
        }

    }
    public boolean isAPalindrome(String s,int st,int end){
        for(int i=st;i<end;i++){
            if(s.charAt(i)!=s.charAt(end))return false;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s="abbab";
        Ex131_PalindromePartitioning test=new Ex131_PalindromePartitioning();
        test.partition(s);
    }

}
