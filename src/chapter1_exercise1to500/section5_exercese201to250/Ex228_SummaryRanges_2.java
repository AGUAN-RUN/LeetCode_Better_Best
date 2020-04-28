package chapter1_exercise1to500.section5_exercese201to250;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
* */
public class Ex228_SummaryRanges_2 {
    //优化

    //书写更为优美的代码
    //12ms  击败9.71%

    //别人家用StringBuilder 拼接字符串好快 0ms 还是不要用 + 了，效率低且会产生无效的字符串碎片
    public List<String> summaryRanges(int[] nums) {
        List<String>result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;
        int st=0;
        for(int i=0;i<nums.length;i++){
            if(i+1>=nums.length||nums[i+1]!=nums[i]+1){
                if(st==i){
                    result.add(nums[i]+"");
                }else {
                    result.add(nums[st]+"->"+nums[i]);
                }
                st=i+1;
            }
        }
        return result;
    }
}
