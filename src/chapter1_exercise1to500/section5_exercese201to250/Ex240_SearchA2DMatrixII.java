package chapter1_exercise1to500.section5_exercese201to250;
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
* */

/*
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
 

示例 1：


输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
输出：true
示例 2：


输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
输出：false
 

提示：

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matix[i][j] <= 109
每行的所有元素从左到右升序排列
每列的所有元素从上到下升序排列
-109 <= target <= 109


* */
public class Ex240_SearchA2DMatrixII {

    //执行用时6ms  击败99.83%
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)return false;
        int m=matrix.length-1;
        int n=0;
        //由于左下角的元素对于一列是最大，对应一行是最小，可以根据目标值和这个元素的大小来对比
        //如果相等则返回结果，如果小于 列号减去1  如果大于行号加一
        while(m>=0&&n<matrix[0].length){
            if(target==matrix[m][n]){
                return true;
            }else if(target<matrix[m][n]){
                m--;
            }else {
                n++;
            }
        }
        return false;
    }
}
