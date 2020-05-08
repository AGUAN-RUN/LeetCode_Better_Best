package chapter1_exercise1to500.section5_exercese201to250;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
* */
public class Ex279_PerfectSquares_2 {
    //动态规划求解  优化1  用一个数组来缓存已经计算的 n；再用一个数组保存小于等于n的所有平方数
    //递归问题先建立  递归表达式
    //用时120ms  java击败19.30%
    public int numSquares(int n) {
        //初始化俩个辅助数组
        int[] nums=new int[n+1];
        Arrays.fill(nums,Integer.MAX_VALUE);
        int maxIndex=(int)Math.sqrt(n)+1;
        int[] sqrtNums=new int[maxIndex];
        for(int i=1;i<sqrtNums.length;i++){
            int value= i*i;
            sqrtNums[i]=value;
            nums[value]=1;
        }
        return numSquaresWorder(n,nums,sqrtNums);
    }
    public int numSquaresWorder(int n,int [] nums, int [] sqrtNums){
        //nums[n] != Integer.MAX_VALUE  说明这个值已经计算过了
        if(nums[n] != Integer.MAX_VALUE){
            return nums[n];
        }
        int res=Integer.MAX_VALUE;
        for(int i=1;i<sqrtNums.length;i++){
            if(n>sqrtNums[i]){
                int val=numSquaresWorder(n-sqrtNums[i],nums,sqrtNums);
                if(val<res)res=val;
            }else{
                break;
            }
        }
        nums[n]=res+1;
        return res+1;
    }
}
