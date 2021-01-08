package chapter1_exercise1to500.section5_exercese201to250;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers and an integer k, find out whether there are two distinct indices i
and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
* */
/*
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

 

示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false


* */
public class Ex219_ContainsDuplicateII {
    //数组中该数和该树的索引保存到map中

    //用时9ms  击败94.61%
    public boolean containsNearbyDuplicate(int[] nums, int k){
        if(nums==null||nums.length<2)return false;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int index=map.get(nums[i]);
                if(i-index<=k)return true;
                map.put(nums[i],i);
            }else {
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
