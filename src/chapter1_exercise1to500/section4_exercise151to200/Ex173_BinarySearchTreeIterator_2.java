package chapter1_exercise1to500.section4_exercise151to200;

import commons.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;

/*Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.

Note:
next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
*/
public class Ex173_BinarySearchTreeIterator_2 {
    //改进用栈来保存没有遍历过的最右边的节点

    //这里使用ArrayDeque取代Stack
    /*ArrayDeque是Deque接口的一个实现，使用了可变数组，所以没有容量上的限制。
    同时，ArrayDeque是线程不安全的，在没有外部同步的情况下，不能再多线程环境下使用。
    ArrayDeque是Deque的实现类，可以作为栈来使用，效率高于Stack；*/


    private LinkedList<Integer> roots;
    private Iterator<Integer> iterator;

    public Ex173_BinarySearchTreeIterator_2(TreeNode root) {
        roots = new LinkedList<>();

        iterator = roots.listIterator();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return iterator.next();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return iterator.hasNext();
    }
    //通过查找树的中序遍历保存元素到链表中


}
