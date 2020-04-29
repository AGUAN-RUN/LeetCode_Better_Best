package chapter1_exercise1to500.section5_exercese201to250;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
Notes:

You must use only standard operations of a stack -- which means only push to top, peek/pop from top,
size, and is empty operations are valid.
Depending on your language, stack may not be supported natively.
You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
* */
public class Ex232_ImplementQueueUsingStacks {
    //use two stack
    //储存元素

    //0ms  100%
    ArrayDeque<Integer>stack1;
    ArrayDeque<Integer>stack2;
    /** Initialize your data structure here. */
    public Ex232_ImplementQueueUsingStacks() {
        stack1=new ArrayDeque<>();
        stack2=new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stack1.isEmpty()){
            stack2.addLast(stack1.removeLast());
        }
        stack1.addLast(x);
        while(!stack2.isEmpty()){
            stack1.addLast(stack2.removeLast());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return  stack1.pollLast();
    }

    /** Get the front element. */
    public int peek() {
        return stack1.peekLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
       return stack1.isEmpty();
    }

    public static void main(String[] args) {
//["MyQueue","push","push","push","pop","pop","pop","empty"]
//[[],[1],[2],[3],[],[],[],[]]
        Ex232_ImplementQueueUsingStacks test=new Ex232_ImplementQueueUsingStacks();
        test.push(1);
        test.push(2);
        test.push(3);
        test.pop();
        test.pop();
        test.pop();
        test.empty();

    }
}
