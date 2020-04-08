package chapter1_exercise1to500.section3_exercise101to150;

import commons.Node;

/*
* You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem

Constraints:

The number of nodes in the given tree is less than 4096.
-1000 <= node.val <= 1000
*/
public class Ex116_PopulatingNextRightPointersInEachNode {
    //不使用额外空间的递归求解

    // 用例执行时间0ms  击败100%
    public Node connect(Node root) {
        if(root==null||root.left==null)return root;
        root.left.next=root.right;
        Node tpl=root.left.right;
        Node tpr=root.right.left;
        //连接下一级子节点下的左右子树
        while(tpl!=null){
            tpl.next=tpr;
            tpl=tpl.right;
            tpr=tpr.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}




















