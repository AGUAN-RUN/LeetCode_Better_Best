package chapter1_exercise1to500.section4_exercise151to200;

import java.util.HashMap;
import java.util.Map;

/*Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
*/
public class Ex167_TwoSumII_InputArrayIsSorted {
    //3ms  击败28.81% 优化优化
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> nums=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            int value=target-numbers[i];
            if(nums.containsKey(value))return new int[]{nums.get(value),i+1};
            nums.put(numbers[i],i+1);
        }
        return new int[2];

    }
}

