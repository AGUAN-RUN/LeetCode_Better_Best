package chapter1_exercise1to500.section7_exercise301to350;
/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).


The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.
* */

/*
给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。


上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。

示例:

给定 matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
说明:

你可以假设矩阵不可变。
会多次调用 sumRegion 方法。
你可以假设 row1 ≤ row2 且 col1 ≤ col2。
通过次数14,624提交次数31,155


* */
public class Ex304_RangeSumQuery2D_Immutable  {
    //matrix[i][j]  记录原 原matrix矩阵  从 matrix[0][0]  到 matrix[i][j] 所有元素的和
    //matrix[i][j]  记录原 原matrix矩阵  从 matrix[0][0]  到 matrix[i][j] 所有元素的和

    //用时14ms  java 击败了99.68%
    int[][]sums;
    public Ex304_RangeSumQuery2D_Immutable(int[][] matrix) {
        if(matrix==null||matrix.length==0)return;
        for (int i=1;i<matrix.length;i++){
            matrix[i][0]+=matrix[i-1][0];
        }
        for (int i=1;i<matrix[0].length;i++){
            matrix[0][i]+=matrix[0][i-1];
        }
        for (int i=1;i<matrix.length;i++){
            for (int j=1;j<matrix[i].length;j++){
                matrix[i][j]=matrix[i][j]+matrix[i-1][j]+matrix[i][j-1]-matrix[i-1][j-1];
            }
        }
        sums=matrix;
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(sums==null)return 0;
        //子矩形和 由一下四个矩形 计算sums[row2][col2]; sums[row2][col1-1];sums[row1-1][col2];sums[row1-1][col1-1];
        if (row1==0 && col1 == 0){
            return sums[row2][col2];
        }else if(row1 == 0){
            return sums[row2][col2]-sums[row2][col1-1];
        }else if(col1==0){
            return sums[row2][col2]-sums[row1-1][col2];
        }
        return sums[row2][col2]-sums[row2][col1-1]-sums[row1-1][col2]+sums[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
