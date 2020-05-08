package chapter1_exercise1to500.section6_exercese251to300;
/*
You are playing the following Nim Game with your friend: There is a heap of stones on the table,
each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner.
 You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game.
Write a function to determine whether you can win the game given the number of stones in the heap.

Example:

Input: 4
Output: false
Explanation: If there are 4 stones in the heap, then you will never win the game;
             No matter 1, 2, or 3 stones you remove, the last stone will always be
             removed by your friend.
* */
public class Ex292_NimGame {
    //这种博弈问题一般都有简明的规律

    //Oms  击败100%
    public boolean canWinNim(int n) {
        //1（先）2（先）3（先）4（后）  n增加1 那么下一个先手只要能把数量减少到 后手能赢的数目就能赢得比赛
        // 若A先手B后手   随着n的增大 将会不断重复 A赢A赢A赢B赢  的局面
          if(n%4==0)return false;
          return true;
    }
}
