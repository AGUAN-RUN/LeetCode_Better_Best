package chapter1_exercise1to500.section8_exercise351to400;

import java.util.ArrayList;
import java.util.Map;

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
class Ex398_RandomPickIndex {

    //用时99ms  java击败 28.36%
    private Map<Integer, ArrayList<Integer>> map;

    public Ex398_RandomPickIndex(int[] nums) {
          if(nums == null || nums.length == 0)return;
          for(int i=0;i<nums.length;i++){
              ArrayList<Integer> list = map.get(nums[i]);
              if(list == null){
                  list=new ArrayList<>();
                  list.add(i);
                  map.put(nums[i],list);
              }else {
                  list.add(i);
              }
          }
    }

    public int pick(int target) {
         if(map == null || !map.containsKey(target))return -1;
         ArrayList<Integer> list = map.get(target);
         return list.get((int)(list.size()*Math.random()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
