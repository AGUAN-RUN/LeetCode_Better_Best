package chapter1_exercise1to500.section1_exercise1to50;


public class WordSearch2{
    public boolean exist(char[][] board, String word) {
        //对于第一次提交的优化
        if(board==null||board.length==0||board[0]==null||board[0].length==0||word==null)return false;
        int m=board.length, n=board[0].length;
        char[]words=word.toCharArray();
        boolean[][]used=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(existWorker(board,used,words,0,i,j,m,n))return true;
            }
        }
        return false;
    }
    //四周搜索递归算法，不使用重复元素
    public boolean existWorker(char[][]board,boolean[][]used,char[]words,int i,int x,int y,int m ,int n){
        if(used[x][y]==true)return false;
        if(board[x][y]!=words[i])return false;
        if(i==words.length-1)return true;
        used[x][y]=true;
        if(x-1>=0&&existWorker(board,used,words,i+1,x-1,y,m,n))return true;
        if(x+1<m&&existWorker(board,used,words,i+1,x+1,y,m,n))return true;
        if(y-1>=0&&existWorker(board,used,words,i+1,x,y-1,m,n))return true;
        if(y+1<n&&existWorker(board,used,words,i+1,x,y+1,m,n))return true;
        used[x][y]=false;
        return false;
    }
}