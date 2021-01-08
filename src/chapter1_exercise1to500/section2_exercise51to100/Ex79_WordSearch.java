package chapter1_exercise1to500.section2_exercise51to100;
/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
 

提示：

board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3


* */
public class Ex79_WordSearch {
    public boolean exist(char[][] board, String word) {
        //这是一个递归问题
        if(board==null||board.length==0||board[0]==null||board[0].length==0||word==null)return false;
        char[]words=word.toCharArray();
        boolean[][]used=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==words[0]){
                    used[i][j]=true;
                    if(existWorker(board,used,words,1,i,j))return true;
                    used[i][j]=false;
                }
            }
        }
        return false;
    }
    //四周搜索递归算法，不使用重复元素
    public boolean existWorker(char[][]board,boolean[][]used,char[]words,int i,int x,int y){
        if(i==words.length)return true;
        int j=x;
        int k=y-1;
        if(existWorkerDetail(board,used,words,i,j,k))return true;
        j=x;
        k=y+1;
        if(existWorkerDetail(board,used,words,i,j,k))return true;
        j=x-1;
        k=y;
        if(existWorkerDetail(board,used,words,i,j,k))return true;
        j=x+1;
        k=y;
        if(existWorkerDetail(board,used,words,i,j,k))return true;
        return false;

    }
    public boolean existWorkerDetail(char[][]board,boolean[][]used,char[]words,int i,int j,int k){
        if(0<=j&&j<board.length&&0<=k&&k<board[0].length&&board[j][k]==words[i]&&used[j][k]==false){
            used[j][k]=true;
            if(existWorker(board,used,words,i+1,j,k))return true;
            used[j][k]=false;
            return false;
        }
        return false;
    }
}