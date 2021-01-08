package chapter1_exercise1to500.section2_exercise51to100;

/*73.给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
* 时间复杂度 O(m*n)
* 空间复杂度 O(1)
* */
/*
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例 1:

输入:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
示例 2:

输入:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
进阶:

一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个常数空间的解决方案吗？


* */
public class Ex73_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        //原地算法  不使额外空间
        //一个直接的解决方案是使用  O(mn) 的额外空间
        //用第一行的元素来决定每一列是否为零，用第一列的元素来决定每一行是否为0
        //考虑程序的鲁棒性
        if(matrix==null||matrix.length==0)return;
        //第一行是否都为0
        boolean isFirstRowZero=false;
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                isFirstRowZero=true;
            }
        }
        //第一列是否都为0
        boolean isFirstColumnZero=false;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                isFirstColumnZero=true;
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        //先判断除了第一行，第一列，其他行数是否为零
        //先行
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        //后列
        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                for(int j=1;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
        //matrixp[0][0]为0,第一行第一列是都为0
        if(isFirstColumnZero){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
        if(isFirstRowZero){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
    }
}
