package chapter1_exercise1to500.section3_exercise101to150;
/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.
*/
public class Ex121_BestTimeToBuyAndSellStock_4 {
    //尝试设计时间复杂度为O(n)的算法
    //一个更为简单直接有针对性的算法

    //1ms 击败99%
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int value = prices[i] - min;
            max = max < value ? value : max;
            if (prices[i] < min) min = prices[i];
        }
        return max;
       /* int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i10;*/
    }

}
