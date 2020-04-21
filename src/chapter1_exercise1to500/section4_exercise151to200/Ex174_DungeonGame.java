package chapter1_exercise1to500.section4_exercise151to200;
/*
* The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid.
* Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
Some of the rooms are guarded by demons,
so the knight loses health (negative integers) upon entering these rooms;
other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

Note:
The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
*/
public class Ex174_DungeonGame {
    //动态规划
    
    //反方向求解更为简单
    public int calculateMinimumHP(int[][] dungeon) {
        //第一行
        int n=dungeon.length;
        int m=dungeon[0].length;
        for(int i=dungeon[0].length-1;i>=0;i--){
            dungeon[0][i]=dungeon[0][i]+dungeon[0][i-1];
        }
        //第一列
        for(int i=1;i<dungeon.length;i++){
            dungeon[i][0]=dungeon[i][0]+dungeon[i-1][0];
        }

        for(int i=1;i<dungeon.length;i++){
            for(int j=1;j<dungeon[0].length;j++){
                int val=dungeon[i-1][j]>dungeon[i][j-1]?dungeon[i-1][j]:dungeon[i][j-1];
                dungeon[i][j]+=val;
            }
        }
        int result=dungeon[dungeon.length-1][dungeon[0].length-1];
        return result>0?0:result;
    }
}
