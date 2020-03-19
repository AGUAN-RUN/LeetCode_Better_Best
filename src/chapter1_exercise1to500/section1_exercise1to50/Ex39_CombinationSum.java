package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex39_CombinationSum {
    //类似于切钢条的动态规划问题，递归求解
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //start 用来显示切分位置,确保不会有重复结果
        int start=0;
        Arrays.sort(candidates);
        List<List<Integer>>results=new ArrayList<List<Integer>>();
        List<Integer>result=new ArrayList<Integer>();
        combinationSumSplit(target,start,candidates,results,result);
        return results;
    }
    public void combinationSumSplit(int target,int start,int[] candidates,List<List<Integer>> results , List<Integer>result){
        for(int i=start;i<candidates.length;i++){
            if(target>candidates[i]){
                result.add(candidates[i]);
                combinationSumSplit((target-candidates[i]),i,candidates,results,result);
                result.remove(result.size()-1);
            }else if(target==candidates[i]){
                result.add(candidates[i]);
                results.add(new ArrayList(result));
                result.remove(result.size()-1);
            }else{
                break;
            }
        }
    }
}
