package chapter1_exercise1to500.section1_exercise1to50;

class Ex33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        //直接进行二分查找，开始索引与结束索引分类判断
        if(nums==null||nums.length==0)return -1;
        int st=0;
        int end=nums.length-1;
        if(nums[st]==target)return st;
        if(nums[end]==target)return end;
        while(st+1<end){
            int mid=(st+end)/2;
            if(nums[mid]==target)return mid;
            //由于可能发生了旋转，mid的位置有两种，对于不同的mid，target的位置两种
            if(nums[mid]>nums[st]){
                if(target<nums[mid]&&target>nums[st]){
                    end=mid;
                }else{
                    st=mid;
                }
            }else if(nums[mid]<nums[st]){
                if(target>nums[mid]&&target<nums[end]){
                    st=mid;
                }else{
                    end=mid;
                }
            }

        }
        return -1;
    }
}
