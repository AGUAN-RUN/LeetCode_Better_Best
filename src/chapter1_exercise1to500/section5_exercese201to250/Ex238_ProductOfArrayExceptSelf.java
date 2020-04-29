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
