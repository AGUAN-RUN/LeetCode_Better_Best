package chapter1_exercise1to500.section4_exercise151to200;

import java.util.ArrayList;
import java.util.List;

/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
 

示例:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 

提示：

pop、top 和 getMin 操作总是在 非空栈 上调用。
* */
//先进后出
//测试用时6ms ,击败98%的用户
public class Ex155_MinStack {
    private List<Integer> nums=new ArrayList<>();
    //先初始化为int最大值
    private int min=Integer.MAX_VALUE;
    public Ex155_MinStack() {

    }
    public void push(int x) {
        nums.add(x);
        if(x<this.min)this.min=x;
    }

    public void pop() {
        if(nums.remove(nums.size()-1)==this.min){
            int min=Integer.MAX_VALUE;
            for(int i:nums){
                if(i<min)min=i;
            }
            this.min=min;
        }
    }

    public int top() {
        return nums.get(nums.size()-1);
    }

    public int getMin() {
        return this.min;
    }
}
