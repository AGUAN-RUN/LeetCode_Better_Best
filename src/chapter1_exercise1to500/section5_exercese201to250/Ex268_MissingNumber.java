package chapter1_exercise1to500.section5_exercese201to250;
/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
* */
public class Ex268_MissingNumber {
    //0ms  击败100%
    public int missingNumber(int[] nums) {
        int sum=(nums.length)*(nums.length+1)/2;
        for(int i=0;i<nums.length;i++){
            sum-=nums[i];
        }
        return sum;
    }
}
