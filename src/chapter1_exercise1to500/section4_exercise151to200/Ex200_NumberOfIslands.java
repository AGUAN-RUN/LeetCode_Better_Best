package chapter1_exercise1to500.section4_exercise151to200;
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

        Example 1:

        Input:
        11110
        11010
        11000
        00000

        Output: 1
        Example 2:

        Input:
        11000
        11000
        00100
        00011

        Output: 3
* */
/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

 

示例 1：

输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
示例 2：

输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3
 

提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'


* */
public class Ex200_NumberOfIslands {
    //遍历grid  遍历过程中 发现岛屿  结果加一  然后递归的把所有所有相邻的岛屿重置为0

    //2ms  一次提交  击败96.83% 的java提交
    public int numIslands(char[][] grid) {
         int res=0;
         for(int i=0;i<grid.length;i++){
             for(int j=0;j<grid[0].length;j++){
                 if(grid[i][j]=='1'){
                     res++;
                     resetNeighborIslandsToZero(grid,i,j);
                 }
             }
         }
         return res;
    }
    public void resetNeighborIslandsToZero(char[][]grid,int m,int n){
         grid[m][n]=0;
         if(m>0&&grid[m-1][n]=='1')resetNeighborIslandsToZero(grid,m-1,n);
         if(n>0&&grid[m][n-1]=='1')resetNeighborIslandsToZero(grid,m,n-1);
         if(m<grid.length-1&&grid[m+1][n]=='1')resetNeighborIslandsToZero(grid,m+1,n);
         if(n<grid[0].length-1&&grid[m][n+1]=='1')resetNeighborIslandsToZero(grid,m,n+1);
    }
}
