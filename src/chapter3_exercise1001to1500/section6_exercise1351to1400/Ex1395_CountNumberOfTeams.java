package chapter3_exercise1001to1500.section6_exercise1351to1400;
/*
* There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

You have to form a team of 3 soldiers amongst them under the following rules:

Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-number-of-teams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


Constraints:

n == rating.length
1 <= n <= 200
1 <= rating[i] <= 10^5
*/
public class Ex1395_CountNumberOfTeams {
    public int numTeams(int[] rating) {
        //暴力法
        //先找能小到大
        //再找大到小
        int result=0;
        if(rating==null||rating.length<3)return result;
        for(int i=0;i<rating.length-2;i++){
            for(int j=i+1;j<rating.length-1;j++){
                for(int k=j+1;k<rating.length;k++){
                    if(rating[i]>rating[j]&&rating[j]>rating[k])result++;
                    if(rating[i]<rating[j]&&rating[j]<rating[k])result++;
                }
            }
        }
        return result;
    }
}
