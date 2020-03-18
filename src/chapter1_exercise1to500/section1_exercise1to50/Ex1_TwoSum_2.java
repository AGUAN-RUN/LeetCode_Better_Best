package chapter1_exercise1to500.section1_exercise1to50;

import java.util.HashMap;
import java.util.Map;

public class Ex1_TwoSum_2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer>am=new HashMap<>();
            for(int i=0;i<nums.length;i++){
                am.put((target-nums[i]),i);
            }

            for(int i=0;i<nums.length;i++){
                if(am.containsKey(nums[i])&&am.get(nums[i])!=i){
                    int j=am.get(nums[i]);
                    int[]result={i,j};
                    return result;
                }

            }
            return null;
        }
    }