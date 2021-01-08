package chapter1_exercise1to500.section7_exercise301to350;

import java.util.HashMap;
import java.util.Map;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
* */

/*
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]


* */
public class Ex309_BestTimeToBuyAndSellStockWithCooldown {
   /* //
    Map<Integer,Integer> temp=new HashMap<>();
    public int maxProfit(int[] prices) {
        //预处理股价数组  得到一个股价涨跌的数组
        int[] profits=new int[prices.length];
        for(int i=1;i<prices.length;i++){
            profits[i]=prices[i]-prices[i-1];
        }
      *//*  //OrderStatus=0时，可购买，OrderStatus=1可出售
        int OrderStatus=0;
        int profit=0;*//*
        return maxProfitFind(profits,0,1);

    }
    public int maxProfitFind(int[] prices,int beginIndex,int beginProfit){
        if(!temp.isEmpty() && temp.containsKey(beginIndex)){
            return temp.get(beginIndex);
        }
        for(int i=1;i<prices.length;i++){
            if(prices[i] <= 0) {
                continue;
            }else if((i+1) < prices.length){
                if(prices[i+1] > 0){
                    beginProfit+=prices[i];
                }else if((i+2) < prices.length){
                    if(prices[i+2] <= 0) {
                        beginProfit += prices[i];
                        i += 2;
                    }else{
                        int a=maxProfitFind(prices,i+2 , beginProfit);
                        int value=prices[i+1]+prices[i+2];
                        int b;
                        if(value<0){
                            b=maxProfitFind(prices,i+3,beginProfit+prices[i]);
                        }else {
                            b=
                        }
                    }
                }
            }else {
                int result=beginProfit+prices[i];
                temp.put(beginIndex,result);
                return result;
            }
        }
        temp.put(beginIndex,beginProfit);
        return beginProfit;
    }*/
}
