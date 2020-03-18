package chapter1.section1_99;

public class ClimbingStairs2 {
    //使用动态规划求解,时间复杂度为O(n)
    public int climbStairs(int n) {
        if(n<2)return 1;
        int[]resultArray=new int[n];
        resultArray[0]=1;
        resultArray[1]=2;
        for(int i=2;i<n;i++){
            resultArray[i]=resultArray[i-2]+resultArray[i-1];
        }
        return resultArray[n-1];

    }
}
