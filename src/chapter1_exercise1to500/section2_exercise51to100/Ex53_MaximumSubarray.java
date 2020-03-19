package chapter1_exercise1to500.section2_exercise51to100;

public class Ex53_MaximumSubarray {
    //暴力求解
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length<1)return -1;
        int result=Integer.MIN_VALUE;
        int temp;
        for(int i=0;i<nums.length;i++){
            temp=nums[i];
            if(nums[i]>result)result=nums[i];
            for(int j=i+1;j<nums.length;j++){
                temp+=nums[j];
                if(temp>result)result=temp;
            }
        }
        return result;
    }
}
