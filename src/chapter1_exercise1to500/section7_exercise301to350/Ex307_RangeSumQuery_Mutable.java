package chapter1_exercise1to500.section7_exercise301to350;
/*
*Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
* */
public class Ex307_RangeSumQuery_Mutable {
    //数据预处理   sumRange O(1)   update O(n)    不处理的暴力方法  sumRange O(n)  update O(1)

    //预处理算法  执行用时   92ms java击败25.44%
    int[]sumPre;
    int[]nums;
    public Ex307_RangeSumQuery_Mutable(int[] nums) {
        //数据预处理 保存到sumPre sumPre 第i个元素  保存 nums[0]  到 nums[i]之和
        if(nums==null||nums.length==0)return;
        this.nums=nums;
        sumPre=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            if(i!=0){
                sumPre[i]=sumPre[i-1]+nums[i];
            }else {
                sumPre[i]=nums[i];
            }
        }
    }

    public void update(int i, int val) {
        if(nums==null||nums.length <= i)return;
        int old=nums[i];
        nums[i]=val;
        int dis=val-old;
        for(int j=i;j<sumPre.length;j++){
            sumPre[j]=sumPre[j]+dis;
        }

    }

    public int sumRange(int i, int j) {
        if(nums==null || i<0 || j>=nums.length) return 1;
        if(i == 0){
            return sumPre[j];
        }else {
            return sumPre[j]-sumPre[i-1];
        }
    }
}
