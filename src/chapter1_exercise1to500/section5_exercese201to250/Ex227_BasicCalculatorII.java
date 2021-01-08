package chapter1_exercise1to500.section5_exercese201to250;

import java.util.LinkedList;
import java.util.Stack;

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.

* */
/*
实现一个基本的计算器来计算一个简单的字符串表达式的值。

字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:

输入: "3+2*2"
输出: 7
示例 2:

输入: " 3/2 "
输出: 1
示例 3:

输入: " 3+5 / 2 "
输出: 5
说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。


* */
public class Ex227_BasicCalculatorII {
    //注意空格  和运算的优先级 先计算乘除法

    //运行时间 13ms  击败78.65%  杂乱无章，有较大优化空间
    public int calculate(String s) {
        LinkedList<Integer>listNums=new LinkedList<>();
        LinkedList<Character>listSy=new LinkedList<>();
        s=s.replace(" ","");
        char[]chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]<='9'&&chars[i]>='0'){
                int value=chars[i]-'0';
                while(i+1<chars.length&&chars[i+1]<='9'&&chars[i+1]>='0'){
                    i++;
                    value=value*10+chars[i]-'0';
                }
                listNums.add(value);
            }else if(chars[i]=='+'||chars[i]=='-'){
                listSy.add(chars[i]);
            }else if(chars[i]=='*'||chars[i]=='/'){
                //计算下一个数和从数值列表取上一个数 乘（除）后再把结果放进数值列表
                char sy=chars[i];
                int value=0;
                while(i+1<chars.length&&chars[i+1]<='9'&&chars[i+1]>='0'){
                    i++;
                    value=value*10+chars[i]-'0';
                }
                int subValue=listNums.removeLast();
                if(sy=='*'){
                    listNums.add(subValue*value);
                }else {
                    listNums.add((subValue/value));
                }
            }
        }
        //最后计算加减
        while(!listSy.isEmpty()){
            char sy=listSy.removeFirst();
            int value1=listNums.removeFirst();
            int value2=listNums.removeFirst();
            if(sy=='+'){
                listNums.addFirst(value1+value2);
            }else {
                listNums.addFirst(value1-value2);
            }
        }
        return listNums.get(0);
    }
}
