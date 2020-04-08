package chapter1_exercise1to500.section3_exercise101to150;
/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.
*/
public class Ex121_BestTimeToBuyAndSellStock_3 {
    //用时 2ms   击败65%
    //尝试设计时间复杂度为O(n)的算法
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2)return 0;
        int[]nums=new int[prices.length-1];
        //得出相对变化值放入新数组
        for(int i=1;i<prices.length;i++){
            nums[i-1]=prices[i]-prices[i-1];
        }
        //寻找和最大的子数组
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=nums[i]+sum;
            if(sum<=0){
                sum=0;
                continue;
            }
            if(sum>max)max=sum;
        }
        return max>0?max:0;
    }
}
