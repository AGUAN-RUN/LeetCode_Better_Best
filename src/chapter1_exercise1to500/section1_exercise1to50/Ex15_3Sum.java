package chapter1_exercise1to500.section1_exercise1to50;

import java.util.*;

public class Ex15_3Sum {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>>list=new ArrayList<>();
        if(nums.length<3)return list;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>0)return list;
            while(i>0&&nums[i]==nums[i-1]){
                i++;
                if(i>=nums.length)return list;
            }
            Map<Integer,Integer> map=new HashMap<>();
            for(int j=i+1;j<nums.length;j++) {
                map.put(nums[j], j);
            }
            it:
            for(int j=i+1;j<nums.length;j++) {
                while(j>i+1&&nums[j]==nums[j-1]){
                    j++;
                    if(j>=nums.length)break it;
                }

                int value=0-nums[i]-nums[j];
                if(map.containsKey(value)&&map.get(value)>j)
                    list.add(Arrays.asList(nums[i],nums[j],value));
            }
        }
        return list;
    }
}
