package chapter1_exercise1to500.section7_exercise301to350;

import java.util.Arrays;

/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
* */
public class Ex303_RangeSumQuery_Immutable_2 {
    //nums 数组第i个元素  保存输入数组 从0到i个元素的和   这个思路可以

    //用时11ms  java击败69.26%
    int[]nums;
    public Ex303_RangeSumQuery_Immutable_2(int[] nums) {
       if(nums==null||nums.length==0)return;
       for(int i=1;i<nums.length;i++){
           nums[i]=nums[i]+nums[i-1];
       }
        this.nums=nums;
    }

    public int sumRange(int i, int j) {
        if(nums==null)return 0;
        if(i == 0){
            return nums[j];
        }
        return nums[j]-nums[i-1];
    }

}
