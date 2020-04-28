package chapter1_exercise1to500.section5_exercese201to250;

import java.util.HashMap;
import java.util.Map;

/*
*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
* */
public class Ex220_ContainsDuplicateIII_2 {
    //执行用时 16 ms java击败了77.36% 内存消耗 :41.5 MB 击败了50.00%的用户
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //可以基于桶的，优化为时间复杂度为O(n)的算法

        //迭代中通过删除桶元素来维护桶中的元素和当前迭代元素的下标差值都小于等于k
        //一个桶的大小为  t+1  一个桶只有一个元素，第i个桶中的元素在 (t+1)*i+0 到 (t+1)*i+t之间
        //1、往某个桶中添加员元素时如果发现这个桶中已经有元素，则这两个元素之差必然小于t，这个时候返回ture；
        //2、如果某个元素要添加到的桶没有元素，但是这个数和相邻的桶的元素差值小于等于t，返回true；
        //1和2都不满足的话，把这个元素添加到桶中，继续迭代
        // 如果迭代到某一步还没有返回说明没有已经参加迭代的每一个元素都存在于不同的桶
        if(t<0)return false;
        Map<Long,Long>map=new HashMap<>();
        long m=(long)t+1;
        for(int i=0;i<nums.length;i++){
            long id=getID(nums[i],m);
            if(map.containsKey(id))return true;
            if(map.containsKey(id-1)&&Math.abs(map.get(id-1)-(long)nums[i])<=(long)t)return true;
            if(map.containsKey(id+1)&&Math.abs(map.get(id+1)-(long)nums[i])<=(long)t)return true;
            map.put(id,(long)nums[i]);
            if(i>=k)map.remove((long)getID(nums[i-k],m));
        }
        return false;
    }
    public long getID(long k,long m){
           //对于  -i*m-1到-(i-1)*m的负数要放到第-i-1个桶中(i=0,1,2,3,4,5......)  如果除法的结果是负数则向0取整
        return k<0?(k+1)/m-1:k/m;
    }
}
