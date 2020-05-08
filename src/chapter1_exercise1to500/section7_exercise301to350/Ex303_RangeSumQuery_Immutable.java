package chapter1_exercise1to500.section7_exercise301to350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
public class Ex303_RangeSumQuery_Immutable {
    //用一个二维数组来记录已经计算了的值

    //一个测试用例数组超大  内存溢出了

    long[][]temp;
    int[]nums;
    public Ex303_RangeSumQuery_Immutable(int[] nums) {
        if(nums!=null) {
            this.nums = nums;
            temp = new long[nums.length][];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = new long[temp.length - i];
                Arrays.fill(temp[i], Long.MAX_VALUE);
            }
        }
    }

    public int sumRange(int i, int j) {
        if(j<i||i<0)return -1;
        if(nums==null||nums.length==0)return -1;
         if(temp[i][j-i]!=Long.MAX_VALUE){
             return (int)temp[i][j-i];
         }
         int res=0;
         for(int k =i;k<=j;k++){
             res+=nums[k];
         }
         temp[i][j-i]=res;
         return res;
    }

}
