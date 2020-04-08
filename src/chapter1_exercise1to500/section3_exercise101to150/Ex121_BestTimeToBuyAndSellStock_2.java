package chapter1_exercise1to500.section3_exercise101to150;
/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.
*/
public class Ex121_BestTimeToBuyAndSellStock_2 {
    //分治法，优于暴力求解  一个连续子数组  要么都在左边，要么都在右边，要么横跨中间
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2)return 0;
        int[]nums=new int[prices.length-1];
        for(int i=1;i<prices.length;i++){
            nums[i-1]=prices[i]-prices[i-1];
        }
        int result= bestTimeToBuy(nums,0,nums.length-1);
        return result=result>0?result:0;
    }
    public int bestTimeToBuy(int[] nums,int st,int end){
        int leftBest=0;
        int rightBest=0;
        int midBest=0;
        int mid=(st+end)/2;
        if(mid>st){
            leftBest=bestTimeToBuy(nums,st,mid);
            rightBest=bestTimeToBuy(nums,mid+1,end);
            midBest=getMidBest(nums,st,mid,end);
        }else if(mid==st&&st<end){
            leftBest=nums[st];
            rightBest=nums[end];
            midBest=nums[st]+nums[end];
        }else if(st==end){
            return nums[st];
        }
        if(leftBest>=rightBest&&leftBest>=midBest){
            return leftBest;
        }else if(rightBest>=leftBest&&rightBest>=midBest){
            return rightBest;
        }else{
            return midBest;
        }
    }
    //获得横跨中点的子数组和的最大值
    public int getMidBest(int[] nums, int st,int mid,int end){
        int maxl=nums[mid];
        int maxr=nums[mid+1];
        int r=nums[mid];
        int l=nums[mid+1];
        for(int i=mid-1;i>=st;i--){
            r=r+nums[i];
            if(r>maxl)maxl=r;
        }
        for(int i=mid+2;i<=end;i++){
            l=l+nums[i];
            if(l>maxr)maxr=l;
        }
        return maxl+maxr;
    }
}
