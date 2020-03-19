package chapter1_exercise1to500.section1_exercise1to50;

import java.util.Arrays;

public class Ex36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        char [] temp= new char[9];
        int count=0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!=46)temp[count++]=board[i][j];
            }
            Arrays.sort(temp,0,count);
            for(int j=1;j<count;j++){
                if(temp[j]==temp[j-1])return false;
            }
            count=0;
            temp=new char[9];
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[j][i]!=46)temp[count++]=board[j][i];
            }
            Arrays.sort(temp,0,count);
            for(int j=1;j<count;j++){
                if(temp[j]==temp[j-1])return false;
            }
            count=0;
            temp=new char[9];
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char k=board[i/3*3+j/3][j%3+i*3%9];
                if(k!='.')temp[count++]=k;
            }
            Arrays.sort(temp,0,count);
            for(int j=1;j<count;j++){
                if(temp[j]==temp[j-1])return false;
            }
            count=0;
            temp=new char[9];
        }
        return true;
    }
}

