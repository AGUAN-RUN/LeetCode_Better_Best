package competition.week5751to5800;
/*英文描述*/
/*
The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).

For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
Given an integer array nums, choose four distinct indices w, x, y, and z such that the product difference
between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.
Return the maximum such product difference.

Example 1:
Input: nums = [5,6,2,7,4]
Output: 34
Explanation: We can choose indices 1 and 3 for the first pair (6, 7) and indices 2 and 4 for the second pair (2, 4).
The product difference is (6 * 7) - (2 * 4) = 34.

Example 2:
Input: nums = [4,2,5,9,7,4,8]
Output: 64
Explanation: We can choose indices 3 and 6 for the first pair (9, 8) and indices 1 and 5 for the second pair (2, 4).
The product difference is (9 * 8) - (2 * 4) = 64.

Constraints:

4 <= nums.length <= 104
1 <= nums[i] <= 104
* */

/*中文题述*/
/*
两个数对 (a, b) 和 (c, d) 之间的 乘积差 定义为 (a * b) - (c * d) 。

例如，(5, 6) 和 (2, 7) 之间的乘积差是 (5 * 6) - (2 * 7) = 16 。
给你一个整数数组 nums ，选出四个 不同的 下标 w、x、y 和 z ，使数对 (nums[w], nums[x]) 和 (nums[y], nums[z]) 之间的 乘积差 取到 最大值 。

返回以这种方式取得的乘积差中的 最大值 。

示例 1：
输入：nums = [5,6,2,7,4]
输出：34
解释：可以选出下标为 1 和 3 的元素构成第一个数对 (6, 7) 以及下标 2 和 4 构成第二个数对 (2, 4)
乘积差是 (6 * 7) - (2 * 4) = 34

示例 2：
输入：nums = [4,2,5,9,7,4,8]
输出：64
解释：可以选出下标为 3 和 6 的元素构成第一个数对 (9, 8) 以及下标 1 和 5 构成第二个数对 (2, 4)
乘积差是 (9 * 8) - (2 * 4) = 64

提示：
4 <= nums.length <= 104
1 <= nums[i] <= 104
* */

import java.util.Arrays;

//优化，直接遍历，取最小的两个值和最大的两个值，相乘相减
//时间复杂度  O(n)  用时2ms,内存38.5MB  在所有的java提交中均击败100%的用户
public class Ex5797_MaximumProductDifferenceBetweenTwoPairs_2 {
    public int maxProductDifference(int[] nums) {
        //最大值max1和次大值max2，最小值min1和次小值min2
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;

        //遍历找值
        for(int i=0;i<nums.length;i++){
            //找最大次大值
            if(nums[i] > max1){
                //先把原值给max2
                max2=max1;
                max1=nums[i];
            }else if(nums[i] > max2){
                max2=nums[i];
            }

            //找最小次小值
            if(nums[i] < min1){
                //先把原值给min2
                min2=min1;
                min1=nums[i];
            }else if(nums[i] < min2){
                min2=nums[i];
            }
        }
        return max1*max2-min1*min2;
    }
}
