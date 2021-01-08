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
/*
实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。

调用 next() 将返回二叉搜索树中的下一个最小的数。

 

示例：



BSTIterator iterator = new BSTIterator(root);
iterator.next();    // 返回 3
iterator.next();    // 返回 7
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 9
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 15
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 20
iterator.hasNext(); // 返回 false
 

提示：

next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。


* */
public class Ex173_BinarySearchTreeIterator {
    //用时37ms  击败14.59%的用户  内存使用击败了100%的用户可还行

    //这种写法没有满足使用O(h)内存  0(h)为树高  应该改进用栈来保存没有遍历过的最右边的节点
    private LinkedList<Integer>roots;
    private Iterator<Integer>iterator;
    public Ex173_BinarySearchTreeIterator(TreeNode root) {
       roots=new LinkedList<>();
       inorderTraversal(root,roots);
       iterator=roots.listIterator();
    }

    /** @return the next smallest number */
    public int next() {
        return iterator.next();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return iterator.hasNext();
    }
    //通过查找树的中序遍历保存元素到链表中
    public void inorderTraversal(TreeNode root,LinkedList<Integer>result){
       if(root==null)return;
        inorderTraversal(root.left,result);
        result.add(root.val);
        inorderTraversal(root.right,result);
    }

}
