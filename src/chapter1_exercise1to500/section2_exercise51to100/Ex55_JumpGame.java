package chapter1_exercise1to500.section2_exercise51to100;
/*
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。


* */
public class Ex55_JumpGame {
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0)return false;
        int n=0;
        int left=0;
        int right=nums[0];
        if(right>=nums.length-1)return true;
        //考虑越界返回，对于返回false和越界返回true的判断
        for(int i=left;i<=right;i++){
            if(nums[i]==0)continue;
            for(int j=i;j<=right;j++){
                if(j!=i&&nums[j]<=nums[j-1]-1)continue;
                if((j+nums[j])>right){
                    right=j+nums[j];
                }
                if(right>=nums.length-1)return true;
            }
            left=i+nums[i]+1;
        }
        return false;
    }
}
