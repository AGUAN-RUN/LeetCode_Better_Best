package chapter1_exercise1to500.section5_exercese201to250;

import java.util.*;

/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
* */
public class Ex241_DifferentWaysToAddParentheses {
    /*分离出数字集和运算符号集合  递归计算    遍历符号集合，符号集合中每个符号做为最后一次运算的符号，都对应一个不同的优先集（不同的加括号方式）
    然后对该符号左右的符号以及对应左右两边的数字进行递归*/

    //假如输入都是合法的
    public List<Integer> diffWaysToCompute(String input) {
        LinkedList<Integer>numsList=new LinkedList<>();
        LinkedList<Character>smptList=new LinkedList<>();
        List<Integer> result=new ArrayList<>();
        char[]chars=input.toCharArray();
        //收集数据到List
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='+'||chars[i]=='-'||chars[i]=='*'||chars[i]=='/'){
                smptList.add(chars[i]);
            }else {
                int value=chars[i]-'0';
                while(i+1<chars.length&&chars[i+1]<'9'&&chars[i+1]>'0'){
                    i++;
                    value=value*10+chars[i]-'0';
                }
                numsList.add(value);
            }
        }
        for(int i=0;i<numsList.size()-1;i++){
           result.add(caculateWorker(getDiffWaysCompute(numsList,smptList,0,i),getDiffWaysCompute(numsList,smptList,i+1,numsList.size()-1),smptList.get(i)));
        }
        return result;
    }
    //这个方法需要改进    计算过的就不再参加计算
    Map<Integer,Map<Integer,Integer>>map=new HashMap<>();
    public int getDiffWaysCompute(List<Integer>numsList,List<Character>smptList,int start,int end){
        if(start==end)return (int)numsList.get(start);
        for(int i=start;i<end;i++){
             caculateWorker(getDiffWaysCompute(numsList,smptList,0,i),getDiffWaysCompute(numsList,smptList,i+1,numsList.size()-1),smptList.get(i));
        }



    }
    public int caculateWorker(int a,int b,char c){
        if(c=='+'){
            return a+b;
        }else if(c=='-'){
            return a-b;
        }else if(c=='*'){
            return a*b;
        }else{
            return a/b;
        }
    }
}
