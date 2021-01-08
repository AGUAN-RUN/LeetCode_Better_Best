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
/*
请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：

实现 MyQueue 类：

void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false
 

说明：

你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 

进阶：

你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 

示例：

输入：
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 1, 1, false]

解释：
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
 

提示：

1 <= x <= 9
最多调用 100 次 push、pop、peek 和 empty
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）


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
