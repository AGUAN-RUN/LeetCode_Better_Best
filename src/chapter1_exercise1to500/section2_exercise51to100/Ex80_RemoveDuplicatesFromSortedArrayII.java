package chapter1_exercise1to500.section2_exercise51to100;

public class Ex80_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        //这道题要用到指针
        if(nums==null||nums.length==0)return 0;
        int index=0;
        int num=nums[0];
        int sum=0;
        int result=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num){
                sum++;
                if(sum==3){
                    index=i;
                    result=result-1;
                    //存在两个以上的重复元素，开始移形换影
                    //移形换影大法
                    for(int j=i+1;j<nums.length;j++){
                        if(num==nums[j]){
                            sum++;
                            if(sum>2){
                                result=result-1;
                                continue;
                            };
                            nums[index]=nums[j];
                            index++;
                        }else{
                            num=nums[j];
                            sum=1;
                            nums[index]=nums[j];
                            index++;
                        }
                    }
                    return result;
                }
            }else{
                num=nums[i];
                sum=1;
            }
        }
        return result;
    }

}
