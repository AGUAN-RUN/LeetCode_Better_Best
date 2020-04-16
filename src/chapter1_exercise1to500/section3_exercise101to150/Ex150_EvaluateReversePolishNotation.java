package chapter1_exercise1to500.section3_exercise101to150;

import java.util.Stack;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:
Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always
evaluate to a result and there won't be any divide by zero operation.
*/
public class Ex150_EvaluateReversePolishNotation {
    //用栈

    //7ms 击败81.64的用户   优化方法1：使用数组来模拟栈    优化方法2：使用递归的方法 看来java Stack的效率也不高啊


    public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length==0)return 0;
        Stack stack=new Stack();
        for(int i=0;i<tokens.length;i++){
            if("+".equals(tokens[i])){
                int b=(Integer) stack.pop();
                int a=(Integer) stack.pop();
                stack.push(a+b);
            }else if("-".equals(tokens[i])){
                int b=(Integer) stack.pop();
                int a=(Integer) stack.pop();
                stack.push(a-b);

            }else if("*".equals(tokens[i])){
                int b=(Integer) stack.pop();
                int a=(Integer) stack.pop();
                stack.push(a*b);

            }else if("/".equals(tokens[i])){
                int b=(Integer) stack.pop();
                int a=(Integer) stack.pop();
                stack.push(a/b);
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return (Integer)stack.pop();
    }
}
