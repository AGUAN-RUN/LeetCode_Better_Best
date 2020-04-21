package chapter3_exercise1001to1500.section7_exercise1401to1450;
/*
* Given the array queries of positive integers between 1 and m, you have to process all queries[i] (from i=0 to i=queries.length-1) according to the following rules:

In the beginning, you have the permutation P=[1,2,3,...,m].
For the current i, find the position of queries[i] in the permutation P (indexing from 0) and then move this at the beginning of the permutation P. Notice that the position of queries[i] in P is the result for queries[i].
Return an array containing the result for the given queries.

Constraints:
1 <= m <= 10^3
1 <= queries.length <= m
1 <= queries[i] <= m
*/
public class Ex1409_QueriesOnAPermutationWithKey {
    //10ms  击败59.67的用户
    public int[] processQueries(int[] queries, int m) {
        if(queries==null||queries.length==0)return queries;
        int [] position=new int[m+1];
        for(int i=1;i<=m;i++){
            position[i]=i-1;
        }
        for(int i=0;i<queries.length;i++){
            int index=position[queries[i]];
            for(int j=1;j<position.length;j++){
                if(position[j]<index)position[j]=position[j]+1;
            }
            position[queries[i]]=0;
            queries[i]=index;
        }
        return queries;
    }
}
