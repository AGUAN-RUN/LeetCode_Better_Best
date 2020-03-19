package chapter1_exercise1to500.section1_exercise1to50;

import java.util.Arrays;

public class Ex16_3SumClosest_2 {
    //别人的思路，先排序，指针指向一个数。然后确定后面两个数。时间复杂度由O(n3)降低为O(n2)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[nums.length-1];
        int result = Integer.MAX_VALUE,left,right,min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            int rangemin = nums[i] + nums[left] + nums[left + 1];
            int rangemax = nums[i] + nums[right] + nums[right - 1];
            if (rangemin > target) {
                if (rangemin - target < min) {
                    result = rangemin;
                    min = rangemin - target;
                }
            }else if (rangemax < target) {
                if (target - rangemax < min) {
                    result = rangemax;
                    min = target - rangemax;
                }
            }else {
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    }else if (sum > target) {
                        right--;
                    }else {
                        return sum;
                    }
                    if (Math.abs(sum - target) < min) {
                        result = sum;
                        min = Math.abs(sum - target);
                    }
                }
            }
        }
        return result;
    }
}
