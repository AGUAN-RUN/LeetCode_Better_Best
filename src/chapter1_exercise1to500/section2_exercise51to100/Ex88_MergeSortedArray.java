package chapter1_exercise1to500.section2_exercise51to100;

public class Ex88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //不适用额外空间，从最右边开始比较最大值，由右向左填充储存结果的数组
        if(n==0)return;
        int length=m+n;
        m=m-1;
        n=n-1;
        for(int i=length-1;i>=0;i--){
            if(m>=0&&n>=0){
                if(nums1[m]>nums2[n]){
                    nums1[i]=nums1[m--];
                }else{
                    nums1[i]=nums2[n--];
                }
            }else if(m<0&&n>=0){
                nums1[i]=nums2[n--];
            }else{
                return;
            }
        }
        return;
    }
}
