package chapter1_exercise1to500.section6_exercese251to300;
/*
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
             received 3, 0, 6, 1, 5 citations respectively.
             Since the researcher has 3 papers with at least 3 citations each and the remaining
             two with no more than 3 citations each, her h-index is 3.
Note: If there are several possible values for h, the maximum one is taken as the h-index.
* */
public class Ex274_H_Index {
    //用时1ms  击败86.29%
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0)return 0;
        //一个辅助的数组,用来统计 引用次数大于其索引i的论文数量
        int[]nums=new int[citations.length+1];
        int max=citations.length;

        for(int i=0;i<citations.length;i++){
            if(citations[i]>=max){
                nums[max]++;
            }else {
                nums[citations[i]]++;
            }
        }
        //从右往左统计 引用次数大于其索引i的论文数量  如果数量大于等于i 就返回；避免不必要的计算
        if(nums[nums.length-1]>=max)return max;
        for(int i=nums.length-2;i>=0;i--){
            nums[i]+=nums[i+1];
            if(nums[i]>=i)return i;
        }
        return 0;
    }
}
