package chapter1_exercise1to500.section2_exercise51to100;
/*给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
        说明：每次只能向下或者向右移动一步。*/
/*
给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

 

示例 1：


输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。
示例 2：

输入：grid = [[1,2,3],[4,5,6]]
输出：12
 

提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100


* */
public class Ex64_MinumumPathSum {
    public int minPathSum(int[][] grid) {
        //使用动态规划求解
        //先左
        for(int i=1;i<grid[0].length;i++){
            grid[0][i]+=grid[0][i-1];
        }
        //后下
        for(int i=1;i<grid.length;i++){
            grid[i][0]+=grid[i-1][0];
        }
        //从上至下，从左至右
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                int min=Math.min(grid[i-1][j],grid[i][j-1]);
                grid[i][j]+=min;
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
