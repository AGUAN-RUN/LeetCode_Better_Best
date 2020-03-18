package chapter1_exercise1to500.section1_exercise1to50;

import java.util.HashMap;
import java.util.Map;

public class Ex1_TwoSum_3 {
    public int[] twoSum(int[] nums, int target) {
        //用来保存结果
        int[] result = new int[2];
        Map<Integer,Integer> map  = new HashMap<>(nums.length);
        //只循环一次，循环过程中，寻找map中是否有target减去nums[i]的余数，有就返回map中这个数的下标和i，map中没有就把这个
        //数作为key，这个数的在数组中的下标作为value放到map中，遍历完之后都没有满足条件的数则查找失败
        for (int i = 0; i < nums.length; i++) {
            int value = target-nums[i];
            Integer index = map.get(value);
            if (index != null) {
                result[0] = index;
                result[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
