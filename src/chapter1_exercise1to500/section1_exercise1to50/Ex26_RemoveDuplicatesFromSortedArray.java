package chapter1_exercise1to500.section1_exercise1to50;

public class Ex26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2)return nums.length;
        int temp=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                temp++;
                nums[temp-1]=nums[i];
            }
        }
        return temp;
    }
}
