package chapter3_exercise1001to1500.section6_exercise1351to1400;

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
