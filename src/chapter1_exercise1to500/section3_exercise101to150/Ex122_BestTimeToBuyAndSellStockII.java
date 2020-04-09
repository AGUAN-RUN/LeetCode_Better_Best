package chapter1_exercise1to500.section3_exercise101to150;
/*
Say you have an array prices for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Constraints:
1 <= prices.length <= 3 * 10 ^ 4
0 <= prices[i] <= 10 ^ 4*/
public class Ex122_BestTimeToBuyAndSellStockII {
    //有涨则买，不跌不卖

    //用例执行时间1ms   击败99%
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2)return 0;
        int sum=0;
        int min=prices[0];
        boolean ifSale=true;
        for(int i=1;i<prices.length;i++){
            if(ifSale) {
                int value = prices[i] - min;
                if (value > 0){
                    sum+=value;
                    ifSale=false;
                }else {
                    min=prices[i];
                }
            }else {
                if(prices[i]>prices[i-1]){
                    sum+=(prices[i]-prices[i-1]);
                }else if(prices[i]<prices[i-1]){
                    ifSale=true;
                    min=prices[i];
                }
            }
        }
        return sum;
    }
}
