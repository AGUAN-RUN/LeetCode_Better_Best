package chapter1_exercise1to500.section2_exercise51to100;

public class Ex70_ClimbingStairs2 {
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
