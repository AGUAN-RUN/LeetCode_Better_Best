package chapter1_exercise1to500.section6_exercese251to300;
/*
Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [0,1,3,5,6]
Output: 3
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
             received 0, 1, 3, 5, 6 citations respectively.
             Since the researcher has 3 papers with at least 3 citations each and the remaining
             two with no more than 3 citations each, her h-index is 3.
Note:

If there are several possible values for h, the maximum one is taken as the h-index.

Follow up:

This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
Could you solve it in logarithmic time complexity?
* */
public class Ex275_H_IndexII {
    //数组长度length  对于索引i有   (length-i)篇论文引用次数 大于等于 citations[i]


    //用时0ms  击败100%
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0)return 0;
        //先判断第一个和‘最后一个’
        int st=0;
        int end=citations.length-1;
        if(citations.length<=citations[st])return citations.length;
        if(0>=citations[end])return 0;
        while (st+1<end){
            int mid=(st+end)/2;
            int num=citations.length-mid;
            if(citations[mid]==num){
                return num;
            }else if(citations[mid]<num){
                st=mid;
            }else{
                end=mid;
            }
        }
        //对于没有返回结果的最终结果一定要仔细分析
        return Math.max(citations[st],citations.length-end);
    }
}
