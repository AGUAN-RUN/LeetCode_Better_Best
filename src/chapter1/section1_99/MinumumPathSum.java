package chapter1.section1_99;
/*给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
        说明：每次只能向下或者向右移动一步。*/
public class MinumumPathSum {
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
