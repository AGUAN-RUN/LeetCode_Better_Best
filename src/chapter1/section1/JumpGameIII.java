package chapter1.section1;

import java.util.Arrays;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        if(arr[start]==0)return true;
        boolean[]isExcute=new boolean[arr.length];
        Arrays.fill(isExcute,false);
        return canReachWorker(arr,isExcute,start);
    }
    public boolean canReachWorker(int[] arr,boolean[]isExcute, int start){
        if(isExcute[start])return false;
        int left=start-arr[start];
        int right=start+arr[start];
        isExcute[start]=true;
        if((left>=0&&left<arr.length)&&(right>=0&&right<arr.length)){
            if(arr[left]==0)return true;
            if(arr[right]==0)return true;
            return canReachWorker(arr,isExcute,left)||canReachWorker(arr,isExcute,right);
        }else if(left>=0&&left<arr.length){
            if(arr[left]==0)return true;
            return canReachWorker(arr,isExcute,left);
        }else if(right>=0&&right<arr.length){
            if(arr[right]==0)return true;
            return canReachWorker(arr,isExcute,right);
        }else{
            return false;
        }
    }
}
