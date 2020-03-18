package chapter1_exercise1to500.section1_exercise1to50;
/* 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
   此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。*/
public class SortColors {
    public void sortColors(int[] nums) {
        //两趟扫描算法
        int[]colorNums=new int[3];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                colorNums[0]++;
            }else if(nums[i]==1){
                colorNums[1]++;
            }else{
                colorNums[2]++;
            }
        }
        int j=0;
        for(int i=0;i<colorNums.length;i++){
            while(colorNums[i]>0){
                nums[j++]=i;
                colorNums[i]--;
            }
        }

    }
}
