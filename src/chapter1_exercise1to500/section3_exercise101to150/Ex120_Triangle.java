package chapter1_exercise1to500.section3_exercise101to150;

import java.util.List;

/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

/*
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

 

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

 

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。


* */
public class Ex120_Triangle {
    //自顶向下，逐层计算
    //运行7ms，击败18
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0)return 0;
        if(triangle.size()==1)return triangle.get(0).get(0);
        int result=Integer.MAX_VALUE;
        for(int i=1;i<triangle.size();i++){
            List<Integer>temp=triangle.get(i-1);
            List<Integer>tempNext=triangle.get(i);
            for(int j=0;j<tempNext.size();j++){
                if(j==0){
                    tempNext.set(j,tempNext.get(0)+temp.get(0));
                }else if(j==tempNext.size()-1){
                    tempNext.set(j,tempNext.get(j)+temp.get(j-1));
                }else{
                    int min=temp.get(j-1)>temp.get(j)?temp.get(j):temp.get(j-1);
                    tempNext.set(j,tempNext.get(j)+min);
                }
                if(i==triangle.size()-1){
                    int value=tempNext.get(j);
                    result=value<result?value:result;
                }
            }
        }
        return result;
    }
}
