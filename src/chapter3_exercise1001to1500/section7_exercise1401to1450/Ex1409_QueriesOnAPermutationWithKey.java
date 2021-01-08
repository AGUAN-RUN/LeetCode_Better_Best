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

/*
给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。

如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。

 

示例 1：

输入：words = ["mass","as","hero","superhero"]
输出：["as","hero"]
解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
["hero","as"] 也是有效的答案。
示例 2：

输入：words = ["leetcode","et","code"]
输出：["et","code"]
解释："et" 和 "code" 都是 "leetcode" 的子字符串。
示例 3：

输入：words = ["blue","green","bu"]
输出：[]
 

提示：

1 <= words.length <= 100
1 <= words[i].length <= 30
words[i] 仅包含小写英文字母。
题目数据 保证 每个 words[i] 都是独一无二的。


* */
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
