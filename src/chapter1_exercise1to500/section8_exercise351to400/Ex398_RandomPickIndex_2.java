package chapter1_exercise1to500.section8_exercise351to400;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/*
Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
* */
class Ex398_RandomPickIndex_2 {

    //蓄水池抽样算法  和一相比，构造方法的复杂度为  O(1)    pick方法复杂度为 O(n)   适用于pick操作不频繁的场景

    //用时 67ms jaba击败93%
    private Random random;
    private int[] nums;

    public Ex398_RandomPickIndex_2(int[] nums) {
         this.random = new Random();
         this.nums = nums;
    }
    //蓄水池抽样算法  遍历数组，对于第i个target  从0到i-1 随机选取一个数j  如果j=0 则令index=第i个target 在数组中的索引
    //遍历完数组之后，返回index的值。   如果数组中有n个i 那么每个target索引被返回的概率都是  1 * 1/2 * 2/3 * ... * (n-1)/n  = 1/n
    public int pick(int target) {
         if(nums == null || nums.length == 0)return -1;
         int res=0;
         int index=0;
         for(int i = 0 ;i < nums.length;i++){
             if(nums[i] != target){
                 continue;
             }
             index++;
             if(random.nextInt(index) == 0){
                 res=i;
             }
         }
         return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
