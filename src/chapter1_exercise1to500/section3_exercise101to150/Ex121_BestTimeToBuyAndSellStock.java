package chapter1_exercise1to500.section3_exercise101to150;
/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.
*/
public class Ex121_BestTimeToBuyAndSellStock {
    //暴力求解法
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2)return 0;
        int result=0;//我可以不买
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                int val=prices[j]-prices[i];
                if(val>result)result=val;
            }
        }
        return result;
    }
}
