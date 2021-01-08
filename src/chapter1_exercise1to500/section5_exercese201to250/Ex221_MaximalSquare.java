package chapter1_exercise1to500.section5_exercese201to250;
/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
* */
/*
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

 

示例 1：


输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
输出：4
示例 2：


输入：matrix = [["0","1"],["1","0"]]
输出：1
示例 3：

输入：matrix = [["0"]]
输出：0
 

提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] 为 '0' 或 '1'


* */
public class Ex221_MaximalSquare {
    //回溯法

    //用时4ms  击败98.78%
    //回溯法
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0)return 0;
        int max=0;
        int nums=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                //重新初始化
                nums=0;
                if(matrix[i][j]=='1'){
                    nums++;
                    int m=i+1;
                    int n=j+1;
                    //回溯
                    while(m<matrix.length&&n<matrix[0].length){
                        int value=nums;
                        for(int t=j;t<n;t++){
                            if(matrix[m][t]=='1'){
                                nums++;
                            }else {
                                nums=value;
                                break;
                            }
                        }
                        if(nums==value)break;
                        for(int r=i;r<=m;r++){
                            if(matrix[r][n]=='1'){
                                nums++;
                            }else {
                                nums=value;
                                break;
                            }
                        }
                        if(nums==value)break;
                        m++;
                        n++;
                    }
                    if (max<nums)max=nums;
                }

            }
        }
        return max;
    }
}
