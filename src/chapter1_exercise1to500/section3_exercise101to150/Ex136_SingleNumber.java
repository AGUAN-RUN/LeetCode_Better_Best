package chapter1_exercise1to500.section3_exercise101to150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
public class Ex136_SingleNumber {
    //时间复杂度为N但是使用额外空间
    //用时14ms，击败14.98%   。。。。。。
    public int singleNumber(int[] nums){
        Map<Integer,Integer> mps=new HashMap<>();
        for(int i=0;i<nums.length;i++){
           mps.put(nums[i],mps.get(nums[i])==null?1:mps.get(nums[i])+1);
        }
        for(Integer a:mps.keySet()){
            if(mps.get(a)==1)return a;
        }
        return -1;
    }
}
