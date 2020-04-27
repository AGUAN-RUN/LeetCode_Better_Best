package chapter1_exercise1to500.section5_exercese201to250;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
* */
public class Ex217_ContainsDuplicate {
    //用  set  O(n)时间复杂度
    //直接用排序再遍历【O(nlgn)】还更快，说明测试用例输入规模基本很小

    //用时9ms   击败62.48%   一群陈独秀
    public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length<2)return false;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))return true;
            set.add(nums[i]);
        }
        return  false;
    }

}
