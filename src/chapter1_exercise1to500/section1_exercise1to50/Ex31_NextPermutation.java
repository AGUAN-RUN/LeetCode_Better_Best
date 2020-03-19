package chapter1_exercise1to500.section1_exercise1to50;

import java.util.Arrays;

public class Ex31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length<2)return;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>=nums[i+1]){
                if(i==nums.length-2){
                    Arrays.sort(nums);
                    return;
                }
                continue;
            }else{
                break;
            }
        }
        int status=0;
        int min=Integer.MAX_VALUE;
        int minIndex=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]>nums[i]){
                    status=1;
                    if(nums[j]<min){
                        min=nums[j];
                        minIndex=j;
                    }

                }

            }
            if(status==1){
                nums[minIndex]=nums[i];
                nums[i]=min;
                Arrays.sort(nums,i+1,nums.length);
                return;
            }
        }
        return;
    }
}
