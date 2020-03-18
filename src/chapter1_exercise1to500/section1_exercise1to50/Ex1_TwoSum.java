package chapter1_exercise1to500.section1_exercise1to50;


import java.util.HashMap;
import java.util.Map;

public class Ex1_TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++) {
            int sub=target-nums[i];
            if(map.containsKey(sub)&&map.get(sub)!=i) {
                return new int[] {i,map.get(sub)};

            }
        }
        throw new IllegalArgumentException("Don't find!");

    }
}