package chapter1_exercise1to500.section1_exercise1to50;
/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 

示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 

提示：

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4


* */
public class Ex16_3SumClosest {
    //First暴力求解
    public int threeSumClosest(int[] nums, int target) {
        int status=Integer.MAX_VALUE;
        int result=-1;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum=nums[i]+nums[j]+nums[k];
                    int sub=(target-sum)>=0?(target-sum):(sum-target);
                    if(sub==0){
                        return sum;
                    }else if(sub<status){
                        status=sub;
                        result=sum;
                    }
                }
            }
        }
        return result;
    }
}
