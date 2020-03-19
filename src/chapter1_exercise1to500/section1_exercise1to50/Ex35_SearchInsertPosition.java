package chapter1_exercise1to500.section1_exercise1to50;

public class Ex35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0||nums[0]>=target)return 0;
        int length=nums.length;
        if(nums[length-1]<target)return length;
        if(nums[length-1]==target)return length-1;
        int lt=0;
        int rt=length-1;
        int temp;
        while(rt>lt+1){
            temp=(rt+lt)/2;
            if(nums[temp]==target)return temp;
            if(nums[temp]>target){
                rt=temp;
            }else{
                lt=temp;
            }
        }
        return rt;
    }
}
