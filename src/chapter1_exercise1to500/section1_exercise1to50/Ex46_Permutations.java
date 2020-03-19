package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex46_Permutations {
    //递归与  链表(链表的删除操作时间复杂度为O(1))
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null||nums.length==0)return null;
        List<List<Integer>>results = new ArrayList<List<Integer>>();
        List<Integer>result=new ArrayList<>();
        List<Integer>params=new LinkedList<Integer>();
        for(int i=0;i<nums.length;i++){
            params.add(nums[i]);
        }
        getPermuteResult(params,result,results);
        return results;
    }

    public void getPermuteResult(List<Integer> params,List<Integer> result,List<List<Integer>> results){
        if(params.size()==1){
            result.add(params.get(0));
            results.add(new ArrayList<Integer>(result));
            result.remove(result.size()-1);
        }else{
            for(int i=0;i<params.size();i++){
                result.add(params.remove(i));
                getPermuteResult(params,result,results);
                params.add(i,result.remove(result.size()-1));
            }
        }

    }
}
