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
public class Ex228_SummaryRanges_3 {
    //StringBuilder大法

    public List<String> summaryRanges(int[] nums) {
        List<String>result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;
        int st=0;
        //注意  new StringBuilder(nums[0])  是创建一个StringBuilder对象并初始化 容量为 nums[0]
        StringBuilder sb=new StringBuilder().append(nums[0]);
        for(int i=0;i<nums.length;i++){
            if(i+1>=nums.length||nums[i+1]!=nums[i]+1){
                if(st==i){
                    result.add(sb.toString());
                }else {
                    //如果有终点
                    sb.append("->").append(nums[i]);
                    result.add(sb.toString());
                }
                st=i+1;
                //初始化起点字符串
                if(st<nums.length){
                    sb=new StringBuilder();
                    sb.append(nums[st]);
                }
            }
        }
        return result;
    }
}
