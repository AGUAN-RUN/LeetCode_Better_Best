package chapter3_exercise1001to1500.section5_exercise1301to1350;

public class Ex1304_FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        if(n<=0)return null;
        boolean isDouble=n%2==0?true:false;
        int left=-n/2;
        int [] result=new int[n];
        left=-n/2;
        for(int i=0;i<n;i++){
            if(isDouble&&left==0){
                left=left+1;
            }
            result[i]=left++;
        }
        return result;

    }
}