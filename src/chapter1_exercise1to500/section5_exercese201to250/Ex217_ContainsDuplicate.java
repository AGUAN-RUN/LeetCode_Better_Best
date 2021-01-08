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
/*
给定一个整数数组，判断是否存在重复元素。

如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

 

示例 1:

输入: [1,2,3,1]
输出: true
示例 2:

输入: [1,2,3,4]
输出: false
示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true


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
