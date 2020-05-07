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
public class Ex241_DifferentWaysToAddParentheses_3 {
   //分治法➕动态规划

   //对原来的字符串中的每个运算符号的 左右子串递归求解  并把字符串与返回结果的映射保存在map中 同样的字符串只计算一次
    //1ms  java击败100%
    Map<String,List<Integer>>map=new HashMap<>();
   public List<Integer> diffWaysToCompute(String input) {
       if (input == null || input.length() == 0) {
            return new ArrayList<>();
       }
       if(map.containsKey(input)){
           return map.get(input);
       }
       int num = 0;
       int st = 0;
       //判断是否全为数字
       while (st < input.length()){
           char c = input.charAt(st);
           if(c >= '0' && c <= '9') {
               num = num * 10 + input.charAt(st) - '0';
           }else {
               break;
           }
           st++;
       }
       List<Integer>res = new ArrayList<>();
       if (st == input.length()){
           res.add(num);
           return res;
       }
       for(int i=1;i<input.length();i++){
           char c=input.charAt(i);
           if(c == '+' || c == '-' || c == '*' || c == '/') {
               List<Integer> left = diffWaysToCompute(input.substring(0, i));
               List<Integer> right = diffWaysToCompute(input.substring(i + 1));
               for (int a:left){
                   for(int b:right){
                       res.add(caculateWorker(a,b,c));
                   }
               }
           }
       }
       map.put(input,res);
       return res;
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
