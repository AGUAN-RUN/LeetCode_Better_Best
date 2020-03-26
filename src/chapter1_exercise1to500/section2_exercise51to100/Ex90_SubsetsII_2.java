package chapter1_exercise1to500.section2_exercise51to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex90_SubsetsII_2 {
    /*找到正确可用算法的一种好的途径是，使用一个或者几个简单示例先进行演绎，从这些演绎过程中寻找规律，进行演绎归纳。
     使用数学归纳法证明你的猜想，建立循环不变式，再用不变式的性质证明算法的正确性*/
    //回溯法  先选择第一个元素位置再选择右边第二个元素位置...，  通过所有测试1ms 打败100%用户
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        result.add(temp);
        if(nums==null||nums.length==0)return result;
        //排序保证数字按序排列，否则需要暴力遍历并对结果去重
        Arrays.sort(nums);
        getSub(result,nums,temp,0);
        return result;
    }
    public void getSub(List<List<Integer>>result,int[]nums,List<Integer>temp,int start){
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1])continue;
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            getSub(result,nums,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
