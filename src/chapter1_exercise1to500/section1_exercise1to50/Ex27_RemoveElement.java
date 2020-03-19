package chapter1_exercise1to500.section1_exercise1to50;

public class Ex27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0)return 0;
        int temp=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                temp++;
                nums[temp]=nums[i];
            }
        }
        return temp+1;
    }
}
