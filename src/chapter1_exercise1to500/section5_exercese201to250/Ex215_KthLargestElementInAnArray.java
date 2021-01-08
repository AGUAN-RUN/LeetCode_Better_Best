package chapter1_exercise1to500.section5_exercese201to250;

import java.util.PriorityQueue;

/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
* */
/*
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。


* */
public class Ex215_KthLargestElementInAnArray {
    //可以用API先从大到小排序数组，再获取第 k 个数组元素  此时时间复杂度为  O(nlgn)
    //以下实现是基于一个优先级队列  优先队列只保存k个元素，有比优先队列中最小值大的，删除最小值，添加该值

    //用时5ms  击败64.95%
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>queue=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            if(queue.size()<k){
                queue.add(nums[i]);
            }else {
                int value=queue.peek();
                if(nums[i]>value){
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
    }

}
