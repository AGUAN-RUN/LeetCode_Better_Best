package chapter1_exercise1to500.section2_exercise51to100;

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
