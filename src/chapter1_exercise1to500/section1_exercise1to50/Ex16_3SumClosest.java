package chapter1_exercise1to500.section1_exercise1to50;

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
