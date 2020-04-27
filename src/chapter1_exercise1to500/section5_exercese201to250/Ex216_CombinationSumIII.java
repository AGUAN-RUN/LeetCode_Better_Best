package chapter1_exercise1to500.section5_exercese201to250;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
* */
public class Ex216_CombinationSumIII {
    //回溯法加减枝优化
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        LinkedList<Integer>nums=new LinkedList<>();
        for(int i=1;i<10;i++){
            nums.add(i);
        }
        combinationSum3Worker(result,list,nums,k,n,0);
        return result;
    }
    //int st限制了 nums遍历的起始位置，以免出现重复的组合
    public void combinationSum3Worker(List<List<Integer>>result,List<Integer>list,LinkedList<Integer>nums,int k,int n,int st){
        if(k==0||n==0){
            if(k==0&&n==0){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i=st;i<nums.size();i++){
            int value=nums.remove(i);
            list.add(value);
            combinationSum3Worker(result,list,nums,k-1,n-value,i);
            list.remove(list.size()-1);
            nums.add(i,value);
        }

    }
}
