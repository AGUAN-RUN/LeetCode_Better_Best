package chapter1_exercise1to500.section2_exercise51to100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

 

示例 1：

输入：n = 3, k = 3
输出："213"
示例 2：

输入：n = 4, k = 9
输出："2314"
示例 3：

输入：n = 3, k = 1
输出："123"
 

提示：

1 <= n <= 9
1 <= k <= n!


* */
public class Ex60_PermutationSequence {
    //使用递归
    //思路：n个数有n!个排列,如果(m-1)!<k<m! 说明排列的情况中第1个数到第n-m个数的位置没有变动
    public String getPermutation(int n, int k) {
        if(n<1||k<1)return null;
        StringBuilder sb=new StringBuilder();
        List<Integer> nums=new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            nums.add(i);
        }
        List<Integer>ptNums=new ArrayList<Integer>();
        ptNums.add(1);
        ptNums.add(2);
        for(int i=1;i<=n;i++){
            if(k==1){
                numsToSb(nums,sb,0);
                break;
            }else if(k<ptNums.get(i)){
                numsToSb(nums,sb,i+1);
                int index=k/ptNums.get(i-1);
                int nevK=k%ptNums.get(i-1);
                if(nevK!=0){
                    sb.append(nums.remove(index));
                    getSubPermutation(sb,nums,ptNums,nevK);
                }else{
                    sb.append(nums.remove(index-1));
                    while(nums.size()!=0){
                        sb.append(nums.remove(nums.size()-1));
                    }
                }
                break;
            }else if(k==ptNums.get(i)){
                numsToSb(nums,sb,i+1);
                while(nums.size()!=0){
                    sb.append(nums.remove(nums.size()-1));
                }
                break;
            }
            ptNums.add(ptNums.get(i)*(i+2));
        }
        return sb.toString();
    }
    public void getSubPermutation(StringBuilder sb,List<Integer>nums,List<Integer>ptNums,int k){
        for(int i=1;i<nums.size();i++){
            if(k==1){
                numsToSb(nums,sb,0);
                break;
            }else if(k<ptNums.get(i)){
                numsToSb(nums,sb,i+1);
                int index=k/ptNums.get(i-1);
                int nevK=k%ptNums.get(i-1);
                if(nevK!=0){
                    sb.append(nums.remove(index));
                    getSubPermutation(sb,nums,ptNums,nevK);
                }else{
                    sb.append(nums.remove(index-1));
                    while(nums.size()!=0){
                        sb.append(nums.remove(nums.size()-1));
                    }
                }
                break;
            }else if(k==ptNums.get(i)){
                numsToSb(nums,sb,i+1);
                while(nums.size()!=0){
                    sb.append(nums.remove(nums.size()-1));
                }
                break;
            }
        }
    }
    public void numsToSb(List<Integer>nums,StringBuilder sb,int i){
        int len=nums.size();
        for(int j=0;j<len-i;j++){
            sb.append(nums.remove(0));
        }
    }
}
