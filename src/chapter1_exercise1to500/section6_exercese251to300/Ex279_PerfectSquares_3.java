package chapter1_exercise1to500.section6_exercese251to300;

import java.util.HashSet;
import java.util.Set;

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
public class Ex279_PerfectSquares_3 {
    //贪心算法 + BFS  与方法2相比避免了很多不必要的运算
    //根据数学定理  由于每个数都可以用四个以内的平方数之和表示  所以最多进行四次递归

    //用时 47ms  击败44.48%
    public int numSquares(int n) {
        //初始化俩个辅助数组
        Set<Integer> set = new HashSet<>();
        int maxIndex=(int)Math.sqrt(n)+1;
        int[] powNums = new int[maxIndex];
        int[] sqrtNums = new int[n+1];
        int j=0;
        //填充数据
        for(int i=1;i<powNums.length;i++){
            int value= i*i;
            while(j<value){
                sqrtNums[j]=i-1;
                j++;
            }
            powNums[i]=value;
            if (i == powNums.length-1){
                while(j<sqrtNums.length){
                    sqrtNums[j]=i;
                    j++;
                }
            }
        }

        set.add(n);
        return numSquaresWorker(1,set,powNums,sqrtNums);
    }
    public int numSquaresWorker(int n,Set<Integer>set,int [] powNums, int [] sqrtNums){
        Set<Integer>nextSet=new HashSet<>();
        for(int a:set){
            if(a == powNums[sqrtNums[a]])return n;
            for(int i=sqrtNums[a];i>0;i--){
                nextSet.add(a-powNums[i]);
            }
        }
        return numSquaresWorker(n+1,nextSet,powNums,sqrtNums);
    }
}
