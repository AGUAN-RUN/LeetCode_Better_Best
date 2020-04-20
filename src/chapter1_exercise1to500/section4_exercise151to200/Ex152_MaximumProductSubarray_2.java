package chapter1_exercise1to500.section4_exercise151to200;
/*Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
*/

public class Ex152_MaximumProductSubarray_2 {
    //O(n)时间复杂度算法

    //用时0ms，击败100%的用户
    public int maxProduct(int[] nums) {
        //根据0的位置切分子数组 记录子数组负数数量，统计子数组连续乘积最大值
        if(nums==null||nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int max=Integer.MIN_VALUE;
        int value=1;
        int st=-1,end=-1;
        int neSt=-1, neEnd=-1;
        int negNum=0;
        for(int i=0;i<nums.length;i++){
            value=1;neSt=-1;neEnd=-1;negNum=0;
            while(i<nums.length&&nums[i]==0)i++;
            st=i;
            //在遇到下一个0之前，统计负数的数量
            for (int j = i; j < nums.length; j++) {
                if(nums[j]<0){
                    if(neSt==-1)neSt=j;
                    negNum++;
                    neEnd=j;
                }
                if(nums[j]==0){
                    end=j;
                    i=j;
                    break;
                }
                if(j==nums.length-1){
                    end=nums.length;
                    i=nums.length;
                }
            }
            //判断是否溢出
            if(st>=nums.length)break;
            //更据负数的奇偶和   在本次遍历的子数组中的第一个以及最后一个负数来区别计算最大值
            if(negNum%2==0){
                for(int j=st;j<end;j++){
                    value*=nums[j];
                }
                if(value>max)max=value;
            }else {
                if(neEnd==neSt&&st==end-1){
                    if(nums[st]>max)max=nums[st];
                }else{
                    for(int j=neSt+1;j<end;j++){
                        value*=nums[j];
                    }
                    if(value>max)max=value;
                    value=1;
                    for(int j=st;j<neEnd;j++){
                        value*=nums[j];
                    }
                    if(value>max)max=value;
                }
            }
        }
        return max<0?0:max;
    }
}
