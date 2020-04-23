package chapter1_exercise1to500.section4_exercise151to200;
/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/
public class Ex189_RotateArray_3 {
    //三次翻转的翻转方法不够优美，不够灵性，优化

    //优化之后，  0ms 击败100%
    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length==0)return;
        k=k%nums.length;
        if(k==0)return;
        //一次
        reverseArray(nums,0,nums.length-1);
        //二次
        reverseArray(nums,0,k-1);
        //三次
        reverseArray(nums,k,nums.length-1);
    }
    public void reverseArray(int []nums,int begin,int end){
        while (begin<end){
            int value=nums[begin];
            nums[begin++]=nums[end];
            nums[end--]=value;
        }
    }
}
