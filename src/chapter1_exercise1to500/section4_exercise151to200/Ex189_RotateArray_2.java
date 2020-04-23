package chapter1_exercise1to500.section4_exercise151to200;
/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/
public class Ex189_RotateArray_2 {
    //第一个解法使用了额外空间  采用三次反转，不使用额外空间

    //1ms java击败60%
    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length==0)return;
        k=k%nums.length;
        if(k==0)return;
        //一次
        reverseArray(nums,0,nums.length);
        //二次
        reverseArray(nums,0,k);
        //三次
        reverseArray(nums,k,nums.length);
    }
    public void reverseArray(int []nums,int begin,int end){
        int mid=(begin+end)/2;
        for(int i=begin;i<mid;i++){
            int value=nums[i];
            nums[i]=nums[end-1-i+begin];
            nums[end-1-i+begin]=value;
        }
    }
//[1,2,3,4,5,6,7]
//3
    public static void main(String[] args) {
        Ex189_RotateArray_2 test=new Ex189_RotateArray_2();
        test.rotate(new int[]{1,2,3,4,5,6,7},3);
    }
}
