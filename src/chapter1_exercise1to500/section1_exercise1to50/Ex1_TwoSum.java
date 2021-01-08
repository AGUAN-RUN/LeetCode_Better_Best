package chapter1_exercise1to500.section1_exercise1to50;


import java.util.HashMap;
import java.util.Map;
/*
* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

* */
/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

 

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
* */

public class Ex1_TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++) {
            int sub=target-nums[i];
            if(map.containsKey(sub)&&map.get(sub)!=i) {
                return new int[] {i,map.get(sub)};

            }
        }
        throw new IllegalArgumentException("Don't find!");

    }
}