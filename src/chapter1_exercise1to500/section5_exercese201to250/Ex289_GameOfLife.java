package chapter1_exercise1to500.section5_exercese201to250;
/*According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
*/
public class Ex289_GameOfLife {
    //执行0ms，击败100%
    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0||board[0].length==0)return;
        int[][]result=new int[board.length][board[0].length];
        //暴力求解，简单做法
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int count=countNeighborLife(board,i,j);
                if(board[i][j]==1){
                    if(count==2||count==3)result[i][j]=1;
                }else {
                    if(count==3)result[i][j]=1;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
               board[i][j]=result[i][j];
            }
        }

    }
    //获得这个“细胞”相邻活细胞总数
    public int countNeighborLife(int[][] board,int m,int n){
        int count=0;
        int m1=m==0?m:m-1;
        int n1=n==0?n:n-1;
        int m2=board.length==m?m:m+1;
        int n2=board[0].length==n?n:n+1;
        for(int i=m1;i<=m2;i++){
            for(int j=n1;j<=n2;j++){
                if(i!=m||n!=j){
                    if(board[i][j]==1)count++;
                }
            }
        }
        return count;
    }
}
