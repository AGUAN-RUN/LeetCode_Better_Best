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
public class Ex241_DifferentWaysToAddParentheses_2 {
    /*分离出数字集和运算符号集合  递归计算    遍历符号集合，符号集合中每个符号做为最后一次运算的符号，都对应一个不同的优先集（不同的加括号方式）
    然后对该符号左右的符号以及对应左右两边的数字进行递归*/

    //假如输入都是合法的


    ///优化点（动态规划的思想，保存子问题的值，避免多次重复计算）  用一个map记录已经计算了的 String值，对于同一个String 不重复计算返回值
    //执行用时2ms  java击败86.78%
    public List<Integer> diffWaysToCompute(String input) {
        LinkedList<Integer>numsList=new LinkedList<>();
        LinkedList<Character>smptList=new LinkedList<>();
        List<Integer> result=new ArrayList<>();
        char[]chars=input.toCharArray();
        //分别收集符号数据到List
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='+'||chars[i]=='-'||chars[i]=='*'||chars[i]=='/'){
                smptList.add(chars[i]);
            }else {
                int value=chars[i]-'0';
                while(i+1<chars.length&&chars[i+1]<='9'&&chars[i+1]>='0'){
                    i++;
                    value=value*10+chars[i]-'0';
                }
                numsList.add(value);
            }
        }
        if(numsList.size()==1){
            result.add(numsList.get(0));
            return result;
        }
        List<Integer>left;
        List<Integer>right;
        //分治法➕递归求解  +动态规划
        map=new HashMap<>();
        for(int i=0;i<numsList.size()-1;i++){
            left=getDiffWaysCompute(numsList,smptList,0,i-1);
            right=getDiffWaysCompute(numsList,smptList,i+1,smptList.size()-1);
            char sym=smptList.get(i);
            for(int a:left){
                for(int b:right){
                    result.add(caculateWorker(a,b,sym));
                }
            }
        }
        return result;
    }

    Map<String,List<Integer>> map;
    public List<Integer> getDiffWaysCompute(List<Integer>numsList,List<Character>smptList,int start,int end){
        List<Integer> result = new ArrayList<>();
        //一定要分析清楚分治递归的过程  以及递归结束条件是否正确
        if(start>end){
            result.add(numsList.get(start));
            return result;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(start).append("-").append(end);
        String key=sb.toString();
        if (map.containsKey(key)){
            return map.get(key);
        }
        List<Integer>left;
        List<Integer>right;
        for(int i=start;i<=end;i++){
            left=getDiffWaysCompute(numsList,smptList,start,i-1);
            right=getDiffWaysCompute(numsList,smptList,i+1,end);
            char sym=smptList.get(i);
            for(int a:left){
                for(int b:right){
                    result.add(caculateWorker(a,b,sym));
                }
            }
        }
        map.put(key,result);
        return result;
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

    public static void main(String[] args) {
        String s="10+5";
        Ex241_DifferentWaysToAddParentheses_2 test=new Ex241_DifferentWaysToAddParentheses_2();
        List<Integer>list=test.diffWaysToCompute(s);
        for(int a:list){
            System.out.println(a);
        }

    }
}
