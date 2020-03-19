package chapter1_exercise1to500.section2_exercise51to100;

public class Ex53_MaximumSubarray_2 {
    //暴力求解太慢了O(n2),尝试改进。基本思路：一个子串的和小于0，最大值串就应该不包含该子串-->可以
    //注意全负数的情况
    //这种其实就是一种精妙的动态规划求解，使用反证法可证明该算法的正确性
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length<1)return -1;
        int result=Integer.MIN_VALUE;
        int temp=0;
        for(int i=0;i<nums.length;i++){
            temp+=nums[i];
            if(temp>result)result=temp;
            if(temp<0)temp=0;
        }
        return result;
    }
}
