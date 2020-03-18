package chapter1_exercise1to500.section2_exercise51to100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。*/
/*注意  [2,1]  和 [1,2] 是同一种组合*/
public class Ex77_Combinations {
    /*实现算法如下*/
    public List<List<Integer>> combine(int n, int k) {
        if(n<k||n<1||k<1)return null;
        //使用递归求解
        List<List<Integer>>results=new ArrayList<List<Integer>>();
        List<Integer>result = new ArrayList<Integer>();
        List<Integer>nums=new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            nums.add(i);
        }
        while(nums.size()>=k){
            result.add(nums.remove(0));
            combineWork(results,result,new ArrayList(nums),k-1);
            result.remove(0);
        }
        return results;
    }
    public void combineWork(List<List<Integer>>results,List<Integer>result,List<Integer>nums,int k){
        if(k>0){
            while(nums.size()>=k){
                result.add(nums.remove(0));
                combineWork(results,result,new ArrayList(nums),k-1);
                result.remove(result.size()-1);
            }
        }else{
            results.add(new ArrayList(result));
        }
    }


    /*如果是要求n个数中拿k个数出来排列的话,递归算法如下*/
    public List<List<Integer>> solution(int n, int k) {
        if(n<k||n<1||k<1)return null;
        //使用递归求解
        List<List<Integer>>results=new ArrayList<List<Integer>>();
        List<Integer>result = new LinkedList<Integer>();
        List<Integer>nums=new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            nums.add(i);
        }
        for(int i=0;i<nums.size();i++){
            int value=nums.remove(i);
            result.add(value);
            combineWork(results,result,nums,k-1);
            nums.add(i,value);
            result.remove(0);
        }
        return results;
    }
    public void Work(List<List<Integer>>results,List<Integer>result,List<Integer>nums,int k){
        if(k>0){
            for(int i=0;i<nums.size();i++){
                int value=nums.remove(i);
                result.add(value);
                combineWork(results,result,nums,k-1);
                nums.add(i,value);
                result.remove(result.size()-1);
            }
        }else{
            results.add(new ArrayList(result));
        }
    }
}
