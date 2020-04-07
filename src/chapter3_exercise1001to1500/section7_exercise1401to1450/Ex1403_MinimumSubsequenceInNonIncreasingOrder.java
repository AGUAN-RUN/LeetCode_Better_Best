package chapter3_exercise1001to1500.section7_exercise1401to1450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non included elements in such subsequence. 

If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array. 

Note that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted in non-increasing order.

Constraints:

1 <= nums.length <= 500
1 <= nums[i] <= 100
*/
public class Ex1403_MinimumSubsequenceInNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int sum2=0;
        for(int i=nums.length-1;i>=0;i--){
            result.add(nums[i]);
            sum2+=nums[i];
            sum-=nums[i];
            if(sum2>sum)return result;
        }
        return result;
    }
}
