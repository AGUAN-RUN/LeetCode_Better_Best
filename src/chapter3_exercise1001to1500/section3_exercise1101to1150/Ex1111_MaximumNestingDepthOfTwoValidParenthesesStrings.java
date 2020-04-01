package chapter3_exercise1001to1500.section3_exercise1101to1150;
/*A string is a valid parentheses string (denoted VPS) if and only if it consists of "(" and ")" characters only, and:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are VPS's, or
It can be written as (A), where A is a VPS.
We can similarly define the nesting depth depth(S) of any VPS S as follows:

depth("") = 0
depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's
depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
For example,  "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.

 

Given a VPS seq, split it into two disjoint subsequences A and B, such that A and B are VPS's (and A.length + B.length = seq.length).

Now choose any such A and B such that max(depth(A), depth(B)) is the minimum possible value.

Return an answer array (of length seq.length) that encodes such a choice of A and B:  answer[i] = 0 if seq[i] is part of A, else answer[i] = 1.  Note that even though multiple answers may exist, you may return any of them.
*/
public class Ex1111_MaximumNestingDepthOfTwoValidParenthesesStrings {
    public int[] maxDepthAfterSplit(String seq) {
        //左右均匀，深度最小,A和B，满足有效括号字符串条件同时，连续左括号尽量最小
        //1ms  击败100%
        char[]seqs=seq.toCharArray();
        int[]result=new int[seqs.length];
        char char1=seqs[0];
        result[0]=0;
        char char2=0;
        int flag=-1;
        for(int i=1;i<seqs.length;i++){
            if(flag==-1){
                if(seqs[i]!=char1){
                    char1=seqs[i];
                    result[i]=0;
                }else{
                    char2=seqs[i];
                    result[i]=1;
                    flag=1;
                }
            }else{
                if(seqs[i]!=char2){
                    char2=seqs[i];
                    result[i]=1;
                }else{
                    char1=seqs[i];
                    result[i]=0;
                    flag=-1;
                }

            }

        }
        return result;
    }
}
