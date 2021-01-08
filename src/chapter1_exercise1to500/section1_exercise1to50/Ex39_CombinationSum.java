package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 

提示：

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500


* */
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
