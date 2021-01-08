package chapter1_exercise1to500.section5_exercese201to250;
/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of
all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array)
fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for
the purpose of space complexity analysis.)
* */

/*
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

 

示例:

输入: [1,2,3,4]
输出: [24,12,8,6]
 

提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

进阶：
你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）


* */
public class Ex238_ProductOfArrayExceptSelf {
    //题目要求不能用除法  如果可以用除法也要注意 数组中可能存在一个或者多个零

    //用时1ms击败100%
    public int[] productExceptSelf(int[] nums) {
        //用一个辅助的数组temp temp[i]保存num[i]左所有数的乘积
        //白嫖nums 新nums[i]保存原nums[i]右边所有数的乘积
        if(nums==null||nums.length==0)return nums;
        int[]temp=new int[nums.length];
        int base=1;
        for (int i=0;i<nums.length;i++){
            temp[i]=base;
            base*=nums[i];
        }
        base=1;
        for(int i=nums.length-1;i>=0;i--){
            int value=base;
            base*=nums[i];
            nums[i]=value;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]*=temp[i];
        }
        return nums;
    }
}
