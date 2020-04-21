package chapter1_exercise1to500.section4_exercise151to200;
/*Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
*/

public class Ex152_MaximumProductSubarray {
    //暴力算法 O(n^2)时间复杂度的算法

    //117ms  击败了5.17%的用户
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int result=Integer.MIN_VALUE,value=0;
        for(int i=0;i<nums.length;i++){
            value=nums[i];
            if(value>result)result=value;
            for(int j=i+1;j<nums.length;j++){
                value*=nums[j];
                if(value>result)result=value;
            }
        }
        return result;
    }
}
