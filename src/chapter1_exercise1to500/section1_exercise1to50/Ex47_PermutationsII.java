package chapter1_exercise1to500.section1_exercise1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

 

示例 1：

输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
示例 2：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

提示：

1 <= nums.length <= 8
-10 <= nums[i] <= 10


* */
public class Ex47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums==null||nums.length<1)return null;
        int start=0;
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer>result = new ArrayList<Integer>();
        List<Integer>params = new LinkedList<Integer>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            params.add(nums[i]);
        }
        getPermuteUniqueList(params,result,results);
        return results;
    }
    public void getPermuteUniqueList(List<Integer> params,List<Integer> result,List<List<Integer>> results){
        if(params.size()==1){
            result.add(params.get(0));
            results.add(new ArrayList<Integer>(result));
            result.remove(result.size()-1);
        }else{
            for(int i=0;i<params.size();i++){
                if(i!=0&&params.get(i)==params.get(i-1))continue;
                result.add(params.remove(i));
                getPermuteUniqueList(params,result,results);
                params.add(i,result.remove(result.size()-1));
            }
        }
    }
}
