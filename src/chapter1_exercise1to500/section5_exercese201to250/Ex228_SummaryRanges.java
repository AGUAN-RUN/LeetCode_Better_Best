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

/*
给定一个无重复元素的有序整数数组 nums 。

返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

列表中的每个区间范围 [a,b] 应该按如下格式输出：

"a->b" ，如果 a != b
"a" ，如果 a == b
 

示例 1：

输入：nums = [0,1,2,4,5,7]
输出：["0->2","4->5","7"]
解释：区间范围是：
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
示例 2：

输入：nums = [0,2,3,4,6,8,9]
输出：["0","2->4","6","8->9"]
解释：区间范围是：
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
示例 3：

输入：nums = []
输出：[]
示例 4：

输入：nums = [-1]
输出：["-1"]
示例 5：

输入：nums = [0]
输出：["0"]
 

提示：

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
nums 中的所有值都 互不相同


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
