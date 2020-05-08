package chapter1_exercise1to500.section6_exercese251to300;

/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
* */
public class Ex260_SingleNumberIII_2 {
    //使用位运算  x^x  = 0     x&(-x)会保留x最右边的一个 而将其他的位的1置零
    // nums所有元素的元素的异或结果反映了两个只出现一次的数的差异   结果为1的位 表示两个数在这一位是不同的
    //可以只保留异或结果的最后一位1  作为掩码；重新遍历数组，num[i]&掩码==0  分为一组 其他的分为一组  进行异或，两个组得到的两个结果就是要返回的元素


    //用时1ms  击败100%
    public int[] singleNumber(int[] nums) {
        int a=nums[0];
        for(int i=1;i<nums.length;i++){
            a=a^nums[i];
        }
        int mask=a&(-a);
        int b=0;
        for(int i=0;i<nums.length;i++){
            if((mask&nums[i])==0)b=b^nums[i];
        }
        return new int[]{b,a^b};
    }
}
