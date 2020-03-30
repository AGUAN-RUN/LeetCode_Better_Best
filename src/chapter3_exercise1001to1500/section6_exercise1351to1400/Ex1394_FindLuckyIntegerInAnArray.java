package chapter3_exercise1001to1500.section6_exercise1351to1400;
/*
* Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.

Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1

Constraints:

1 <= arr.length <= 500
1 <= arr[i] <= 500

*/
public class Ex1394_FindLuckyIntegerInAnArray {
    public int findLucky(int[] arr) {
        if(arr==null||arr.length==0)return -1;
        int[]temp=new int[501];
        for(int i=0;i<arr.length;i++){
            temp[arr[i]]++;
        }
        int result=-1;
        for(int i=1;i<temp.length;i++){
            if(temp[i]==i)result=i;
        }
        return result;
    }
}
