package chapter3_exercise1001to1500.section7_exercise1401to1450;
/*Given a number s in their binary representation. Return the number of steps to reduce it to 1 under the following rules:

If the current number is even, you have to divide it by 2.

If the current number is odd, you have to add 1 to it.

It's guaranteed that you can always reach to one for all testcases.

Constraints:

1 <= s.length <= 500
s consists of characters '0' or '1'
s[0] == '1'
*/
public class Ex1404_NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    //直接将字符串转化为整数，可能由于字符串太长而溢出
    public int numSteps(String s) {
        if(s==null||s.length()==0)return 0;
        s="0"+s;
        char[]strs=s.toCharArray();
        if(strs[strs.length-1]=='0'){
            return caculateNumSteps(strs,-1,0,strs.length-1);
        }else {
            return caculateNumSteps(strs,1,0,strs.length-1);
        }

    }
    public int caculateNumSteps(char[]strs,int flag,int total,int begin){
        if(strs[0]=='0'&&begin==1)return total;
        if(strs[0]=='1'&&begin==0)return total;
        if(flag==1){
            int status=1;
            for(int i=begin;i>=0;i--){
                if(status==0)break;
                if(strs[i]=='1'){
                    strs[i]='0';
                }else {
                    strs[i]='1';
                    status=0;
                }
            }
            return caculateNumSteps(strs,-1,total+1,begin);
        }else {
            begin=begin-1;
            if(strs[begin]=='0'){
                return caculateNumSteps(strs,-1,total+1,begin);
            }else {
                return caculateNumSteps(strs,1,total+1,begin);
            }
        }
    }
}
