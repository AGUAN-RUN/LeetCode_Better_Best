package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。说明：解集不能包含重复的子集。*/
public class Subsets {
    //一题三千
    //和组合的思路一样，使用递归求解。这个问题就是组合问题的一种变体
    //以下算法在leetcode上的测试用例运行时间 2ms  打败了   10%的用户，有待改进
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>results=new ArrayList<List<Integer>>();
        List<Integer>result=new ArrayList<Integer>();
        results.add(result);
        if(nums==null||nums.length==0)return results;
        List<Integer>numsList=new LinkedList();
        for(int i=0;i<nums.length;i++){
            numsList.add(nums[i]);
        }
        while(numsList.size()>0){
            result.add(numsList.remove(0));
            results.add(new ArrayList(result));
            subsetsWorker(results,result,new LinkedList(numsList));
            result.remove(0);
        }
        return results;
    }
    public void subsetsWorker(List<List<Integer>>results,List<Integer>result,List<Integer>numsList){
        if(numsList.size()>0){
            while(numsList.size()>0){
                result.add(numsList.remove(0));
                results.add(new ArrayList(result));
                subsetsWorker(results,result,new LinkedList(numsList));
                result.remove(result.size()-1);
            }
        }
    }
}
