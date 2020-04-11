package chapter1_exercise1to500.section3_exercise101to150;

import java.util.HashSet;
import java.util.Set;

/*Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
*/

//测试用例时间23ms   击败了5.6%    //优化下 不使用set 先把O改成其他字符，后面再改回来
public class Ex130_SurroundedRegions {
    //先从边界找到所有的不投降的'O',然后把其他的O都置为'X'
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0)return;
        Set<String> dtSurround=new HashSet<>();
        int m=board.length-1;
        int n=board[0].length-1;
        boolean[][]Used=new boolean[board.length][board[0].length];
        //获得不投降的'O'
        for(int i=0;i<=m;i++){
            if(board[i][0]=='O')notSurroundchain(dtSurround,Used,board,i,0);
            if(board[i][n]=='O')notSurroundchain(dtSurround,Used,board,i,n);
        }
        for(int i=1;i<=n-1;i++){
            if(board[0][i]=='O')notSurroundchain(dtSurround,Used,board,0,i);
            if(board[m][i]=='O')notSurroundchain(dtSurround,Used,board,m,i);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'&&!dtSurround.contains(i+"-"+j))board[i][j]='X';
            }
        }
    }
    public void notSurroundchain(Set<String>dtSurround,boolean[][]Used,char[][]board,int m,int n){
        if(Used[m][n]==true)return;
        Used[m][n]=true;
        dtSurround.add(m+"-"+n);
        if(m+1<board.length-1&&board[m+1][n]=='O')notSurroundchain(dtSurround,Used,board,m+1,n);
        if(m-1>0&&board[m-1][n]=='O')notSurroundchain(dtSurround,Used,board,m-1,n);
        if(n+1<board[0].length-1&&board[m][n+1]=='O')notSurroundchain(dtSurround,Used,board,m,n+1);
        if(n-1>0&&board[m][n-1]=='O')notSurroundchain(dtSurround,Used,board,m,n-1);
    }
}
