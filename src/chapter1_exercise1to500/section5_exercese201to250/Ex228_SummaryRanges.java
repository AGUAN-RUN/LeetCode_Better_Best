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
public class Ex228_SummaryRanges {
    //用时  9ms  击败51%
    public List<String> summaryRanges(int[] nums) {
        List<String>result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;
        boolean isEnd=false;
        int st=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                isEnd=true;
            }else {
                if(isEnd){
                    result.add(st+"->"+nums[i-1]);
                    isEnd=false;
                }else {
                    result.add(st+"");
                }
                st=nums[i];
            }
        }
        if(isEnd){
            result.add(st+"->"+nums[nums.length-1]);
        }else{
            result.add(st+"");
        }
        return result;
    }
}
