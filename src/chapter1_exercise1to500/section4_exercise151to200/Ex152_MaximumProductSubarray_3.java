package chapter1_exercise1to500.section4_exercise151to200;
/*Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
*/

public class Ex152_MaximumProductSubarray_3 {
    //O(n)时间复杂度算法

    //用时0ms，击败100%的用户
    //规律法：如果没有0，偶数个负数的话，全部相乘为最大；奇数个负数，从左到右相乘乘到最右边后一个负数之前，和从右到左乘到之后一个负数之前必有一个为最大
    //有0的话，遇到0就把乘法基数重新置为1   相当于对所有的子数组用上述方法求最大值
    public int maxProduct(int[] nums) {
        if(nums==null&&nums.length==0)return 0;
        int result=Integer.MIN_VALUE;
        int baseNum=1;
        //其实还是做了一些无效的举动，数组（或子数组）从左到右相乘乘到最右边后一个负数之后以及从右到左乘到之后一个负数之后没必要再往下乘了
        for(int i=0;i<nums.length;i++){
            baseNum*=nums[i];
            if(baseNum>result)result=baseNum;
            if(nums[i]==0)baseNum=1;
        }
        baseNum=1;
        for(int i=nums.length-1;i>=0;i--){
            baseNum*=nums[i];
            if(baseNum>result)result=baseNum;
            if(nums[i]==0)baseNum=1;
        }
        return result;
    }
}
