package chapter1_exercise1to500.section5_exercese201to250;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
Notes:

You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
* */
public class Ex225_ImplementStackUsingQueues {
    //如果用队列的话使用两个队列来倒卖就行
    private List<Integer> list1;
    /** Initialize your data structure here. */
    public Ex225_ImplementStackUsingQueues() {
         list1=new ArrayList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
         list1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
         return list1.remove(list1.size()-1);
    }

    /** Get the top element. */
    public int top() {
        return list1.get(list1.size()-1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
         return list1.size()==0;
    }
}
