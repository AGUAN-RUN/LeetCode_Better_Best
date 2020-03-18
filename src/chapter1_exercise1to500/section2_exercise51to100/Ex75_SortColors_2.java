package chapter1_exercise1to500.section2_exercise51to100;

public class Ex75_SortColors_2 {
    public void sortColors(int[] nums) {
        //一趟扫描算法,三个指针

        int left=0,i=0,right=nums.length-1;
        while(right>=i){
            if(nums[i]==1){
                i++;
            }else if(nums[i]==0){
                replaceNums(nums,i++,left++);
            }else if(nums[i]==2){
                replaceNums(nums,i,right--);
            }
        }
    }
    public void replaceNums(int[]nums,int i,int j){
        int value=nums[i];
        nums[i]=nums[j];
        nums[j]=value;
    }
}
