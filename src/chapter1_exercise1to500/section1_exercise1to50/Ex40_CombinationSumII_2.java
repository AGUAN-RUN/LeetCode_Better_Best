package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex40_CombinationSumII_2 {
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
            if(i!=start+1&&candidates[i]==candidates[i-1]){
                continue;
            }
            if(target>candidates[i]){
                result.add(candidates[i]);
                combinationSum2Split((target-candidates[i]),i,candidates,results,result);
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
