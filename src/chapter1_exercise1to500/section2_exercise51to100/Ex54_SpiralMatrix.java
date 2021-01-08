package chapter1_exercise1to500.section2_exercise51to100;

import java.util.ArrayList;
import java.util.List;
/*
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]


* */
public class Ex54_SpiralMatrix {
    //从外圈到内圈，读完外圈后，对内圈求解,一圈一圈
    //(0,1)-->(0,n-1)-->(1,n-1)-->(m-1,n-1)-->(m-1,n-2)-->(m-1,0)--(1,0)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<Integer>();
        if(matrix==null||matrix.length<1)return result;
        int m=matrix.length;
        int n=matrix[0].length;
        //由较小的数决定圈数
        int temp=Math.min(m,n);
        int nums=temp/2;
        if(temp%2==1)nums+=1;
        for(int i=0;i<nums;i++){
            if(i==n-i-1&&i==m-i-1){
                result.add(matrix[i][i]);
            }else if(i==n-i-1){
                for(int j=i;j<m-i;j++){
                    result.add(matrix[j][i]);
                }
            }else if(i==m-i-1){
                for(int j=i;j<n-i;j++){
                    result.add(matrix[i][j]);
                }
            }else{
                for(int j=i;j<n-i-1;j++){
                    result.add(matrix[i][j]);
                }
                for(int j=i;j<m-i-1;j++){
                    result.add(matrix[j][n-i-1]);
                }
                for(int j=n-i-1;j>i;j--){
                    result.add(matrix[m-i-1][j]);
                }
                for(int j=m-i-1;j>i;j--){
                    result.add(matrix[j][i]);
                }
            }
        }
        return result;
    }
}
