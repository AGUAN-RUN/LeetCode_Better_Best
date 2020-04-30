package chapter1_exercise1to500.section5_exercese201to250;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
