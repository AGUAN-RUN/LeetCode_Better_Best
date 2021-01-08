package chapter1_exercise1to500.section6_exercese251to300;

import java.util.ArrayList;
import java.util.Iterator;

/*
Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Example:

Assume that the iterator is initialized to the beginning of the list: [1,2,3].

Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
You call next() the final time and it returns 3, the last element.
Calling hasNext() after that should return false.
Follow up: How would you extend your design to be generic and work with all types, not just integer?
* */

/*
给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。

示例:

假设迭代器被初始化为列表 [1,2,3]。

调用 next() 返回 1，得到列表中的第一个元素。
现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？


* */
//用时 7ms  击败45.66%
public class Ex284_PeekingIterator implements Iterator<Integer> {
    //使用ArrayList来模拟
    private ArrayList<Integer>iterator;
    private int index;
    public Ex284_PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        //把迭代器的元素都放入ArrayList中
        this.iterator=new ArrayList<>();
        while(iterator.hasNext()){
            this.iterator.add(iterator.next());
        }
        index=0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return iterator.get(index);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
       return iterator.get(index++);
    }

    @Override
    public boolean hasNext() {
       if(index>=iterator.size())return false;
       return true;
    }
}
