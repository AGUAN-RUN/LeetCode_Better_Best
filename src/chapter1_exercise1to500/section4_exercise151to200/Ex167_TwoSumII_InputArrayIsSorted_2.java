package chapter1_exercise1to500.section4_exercise151to200;

import java.util.HashMap;
import java.util.Map;

/*Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
*/
public class Ex167_TwoSumII_InputArrayIsSorted_2 {
   //使用双指针解题
    //两边逼近法  1ms  击败97.97%
    public int[] twoSum(int[] numbers, int target) {
       int i=0,j=numbers.length-1;
       while(j>i){
           long value=(long)numbers[j]+(long)numbers[i];
           if(value>(long)target){
               j--;
           }else if(value<(long)target){
               i++;
           }else {
               return new int[]{i,j};
           }
       }
        return new int[2];

    }
}

