package chapter1_exercise1to500.section6_exercese251to300;

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

/*
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.


* */
public class Ex279_PerfectSquares {
    //动态规划求解

    //用时725ms  击败5%
    Map<Integer,Integer> map=new HashMap<>();
    public int numSquares(int n) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        int sqrtNum=(int)Math.sqrt(n);
        if(Math.pow(sqrtNum,2) == n){
            map.put(n,1);
            return 1;
        }
        int num=Integer.MAX_VALUE;
        for(int i = 1;i <= sqrtNum;i++){
            int val=numSquares(n-(int)Math.pow(i,2));
            if(val<num)num=val;
        }
        map.put(n,num+1);
        return num+1;
    }
}
