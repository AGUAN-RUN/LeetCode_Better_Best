package chapter1_exercise1to500.section2_exercise51to100;

public class Ex55_JumpGame_2 {
    //反向求解更为简单
    public boolean canJump(int[] nums) {
        int leftPoint=nums.length-1;
        for (int i=nums.length-2;i>=0;i--){
            if (nums[i]>=leftPoint-i)
                leftPoint=i;
        }
        if (leftPoint==0)
            return true;
        else
            return false;
    }
}
