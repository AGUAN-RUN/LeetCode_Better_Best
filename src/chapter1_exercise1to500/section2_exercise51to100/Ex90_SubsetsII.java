package chapter1_exercise1to500.section2_exercise51to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


* */
public class Ex90_SubsetsII {
    //打败22%，由于程序运行中 计算了很多无效的重复，导致了程序效率大幅降低
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //位运算法
        //使用一个和数组规模一样长度的二进制数 来表示每一个子集，当这个数的第n位为1，表示数组第n位在子集中，0则不存在
        //如果不包含重复子集，n个0 到 n个1 这些数可以表示该数组所有可能的子集
        //如果包含重复的元素  则对于重复元素 如  3333  对应   1100 1010 1001 0110 0101 0011 都是 33 只取1100 其他情况视为无效数据  用 0000表示没有3，用1000 表示1个三 用 1100表示两个3，1110三个，1111四个
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        result.add(temp);
        if(nums==null||nums.length==0)return result;
        //先排序
        Arrays.sort(nums);
        long mNum=1<<nums.length;
        it:
        for(long i=1;i<mNum;i++){
            char[]flags=Long.toBinaryString(i).toCharArray();
            temp=new ArrayList<>();
            for(int j=0;j<flags.length;j++){
                if(flags[j]=='0')continue;
                int index=nums.length-flags.length+j;
                if(index>0&&(j==0||flags[j-1]=='0')&&nums[index]==nums[index-1]){
                    continue it;
                }else{
                    temp.add(nums[index]);
                }
            }
            if(temp!=null&&temp.size()!=0) result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        int[]nums={1,2,2};
        List<List<Integer>>result=new Ex90_SubsetsII().subsetsWithDup(nums);
        System.out.println(result.toString());
    }
}
