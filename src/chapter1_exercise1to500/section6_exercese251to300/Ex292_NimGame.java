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

/*
你和你的朋友，两个人一起玩 Nim 游戏：

桌子上有一堆石头。
你们轮流进行自己的回合，你作为先手。
每一回合，轮到的人拿掉 1 - 3 块石头。
拿掉最后一块石头的人就是获胜者。
假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。

 

示例 1：

输入：n = 4
输出：false
解释：如果堆中有 4 块石头，那么你永远不会赢得比赛；
     因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
示例 2：

输入：n = 1
输出：true
示例 3：

输入：n = 2
输出：true
 

提示：

1 <= n <= 231 - 1


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
