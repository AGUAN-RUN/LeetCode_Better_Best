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
