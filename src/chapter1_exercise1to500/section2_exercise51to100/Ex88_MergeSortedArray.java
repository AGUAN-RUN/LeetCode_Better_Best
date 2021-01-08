package chapter1_exercise1to500.section2_exercise51to100;
/*
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

 

说明：

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 

示例：

输入：
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出：[1,2,2,3,5,6]
 

提示：

-10^9 <= nums1[i], nums2[i] <= 10^9
nums1.length == m + n
nums2.length == n


* */
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
