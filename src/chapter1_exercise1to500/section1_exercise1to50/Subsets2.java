package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {
    //用n位二进制数来指示nums中的n个数在一个子集中存不存在，用n个0到n个1的二进制数来表示所有的子集，
    //通过这些二进制数来确定nums数组中对应的元素中在某一个子集中是否存在，即通过这个二进制数来构造子集
    public List<List<Integer>> subsets(int[] nums) {
        //nums
        List<List<Integer>>results=new ArrayList<List<Integer>>();
        long num=(long)Math.pow(2,nums.length);
        for(long i=0;i<num;i++){
            List<Integer>result=new ArrayList<Integer>();
            getSub(result,Long.toBinaryString(i).toCharArray(),nums);
            results.add(result);
        }
        return results;
    }
    public void getSub(List<Integer>result,char [] binaryStrArray,int[]nums){
        for(int i=0;i<binaryStrArray.length;i++){
            if(binaryStrArray[i]=='1')result.add(nums[binaryStrArray.length-1-i]);
        }
    }
}
