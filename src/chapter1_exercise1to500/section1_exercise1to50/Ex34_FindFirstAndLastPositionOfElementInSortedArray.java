package chapter1_exercise1to500.section1_exercise1to50;

public class Ex34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        //null 没有值，一个值，另个值，三个以上的值
        if(nums==null||nums.length==0)return new int[]{-1,-1};
        int lt=0;
        int rt=nums.length-1;
        int temp;
        int start=-1;
        if(nums[0]==target){
            start=0;
        }else if(nums[rt]==target&&nums[rt-1]<target){
            start=rt;
            return new int[]{rt,rt};
        }else{
            while(rt>lt+1){
                temp=(lt+rt)/2;
                if(nums[temp]==target&&nums[temp-1]<target){
                    start=temp;
                    break;
                }else if(nums[temp]>=target){
                    rt=temp;
                }else if(nums[temp]<target){
                    lt=temp;
                }

            }
        }
        if(start==-1){
            return new int[]{-1,-1};
        }else if(start!=-1&&nums[nums.length-1]==target){
            return new int[]{start,nums.length-1};
        }else if(start!=-1&&nums[start+1]>target){
            return new int[]{start,start};
        }else{
            lt=start;
            rt=nums.length-1;
            while(rt>lt+1){
                temp=(lt+rt)/2;
                if(nums[temp]==target&&nums[temp+1]>target){
                    return new int[]{start,temp};
                }else if(nums[temp]>target){
                    rt=temp;
                }else if(nums[temp]<=target){
                    lt=temp;
                }
            }
        }
        return new int[]{-1,-1};

    }
}
