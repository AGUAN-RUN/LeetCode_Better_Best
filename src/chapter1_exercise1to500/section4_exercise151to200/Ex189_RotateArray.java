package chapter1_exercise1to500.section4_exercise151to200;
/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/
public class Ex189_RotateArray {
    //来个暴力的

    //0ms 击败100%
    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length==0)return;
        k=k%nums.length;
        if(k==0)return;
        int[]temp=new int [k];
        int st=0;
        for(int i=nums.length-k;i<nums.length;i++){
            temp[st++]=nums[i];
        }
        for(int i=nums.length-1;i>=k;i--){
            nums[i]=nums[i-k];
        }
        for(int i=0;i<k;i++){
            nums[i]=temp[i];
        }
    }
}
