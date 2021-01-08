package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]


* */
public class Ex40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int start=-1;
        Arrays.sort(candidates);
        List<List<Integer>>results=new ArrayList<List<Integer>>();
        List<Integer>result= new ArrayList<>();
        combinationSum2Split(target,start,candidates,results,result);
        return results;
    }
    public void combinationSum2Split(int target,int start,int[] candidates,List<List<Integer>>results,List<Integer>result){
        for(int i=start+1;i<candidates.length;i++){
            if(target>candidates[i]){
                result.add(candidates[i]);
                combinationSum2Split((target-candidates[i]),i,candidates,results,result);
                result.remove(result.size()-1);
            }else if(target==candidates[i]){
                result.add(candidates[i]);
                if(!results.contains(result)){
                    results.add(new ArrayList(result));
                }
                result.remove(result.size()-1);
            }else{
                break;
            }
        }
    }
}
