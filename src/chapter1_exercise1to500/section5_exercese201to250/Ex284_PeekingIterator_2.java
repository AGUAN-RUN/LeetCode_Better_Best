package chapter1_exercise1to500.section5_exercese201to250;

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

//优化优化  使用工具，使用一个变量 来桥接peek和next

//用时6ms 击败84.86%
public class Ex284_PeekingIterator_2 implements Iterator<Integer> {
    private Iterator<Integer>iterator;
    private Integer temp;
    public Ex284_PeekingIterator_2(Iterator<Integer> iterator) {
        this.iterator=iterator;
        //初始化的时候就调用一次next 保存第一个值到temp中
        next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    //peek  拿temp的值  就不会移动迭代器的指针
    public Integer peek() {
      return temp;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result=temp;
        if(iterator.hasNext()){
            temp=iterator.next();
        }else {
            temp=null;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        if(temp==null)return false;
        return true;
    }
}
